package swing;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	
	
	public static Connection getConnect() {
		String driverName="com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/JavaProject?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "tjddbs6262";
		
		Connection con = null;
		
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url,user,password);
		}catch(ClassNotFoundException e) {
			System.out.println("Connect 인스턴스를 생성하지 못했습니다");
			System.exit(0);
		}catch(SQLException e) {
			
		}
		return con;
	}
	
	public static void close(Connection con,Statement stmt,ResultSet rs) {
		try {
			if(con !=null)con.close();
			if(stmt!=null)stmt.close();
			if(rs!=null)rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void InputPdata(String id,String pw ,String name,int age, int sex , String genre) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		try {
			con = Connect.getConnect();
			
			stmt = con.createStatement();

	
			String sql = "insert into student values(id,pw,name,age,sex,genre)";
			stmt.executeUpdate(sql);
			
			
			} catch (SQLException e) {
				System.out.println("SQL 오류 = " + e.getMessage());
			} finally {
				Connect.close(con, stmt,rs);
			}
		}
}
