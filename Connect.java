package swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	public static Connection getConnect() {						//DB �����Լ�
		String driverName="com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/JavaProject?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "tjddbs6262";
		
		Connection con = null;
		
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(url,user,password);
		}catch(ClassNotFoundException e) {
			System.out.println("Connect �ν��Ͻ��� �������� ���߽��ϴ�");
			System.exit(0);
		}catch(SQLException e) {
			
		}
		
		return con;
	}
	
	public static void close(Connection con,Statement stmt,ResultSet rs) {			//DB��������
		try {
			if(con !=null)con.close();
			if(stmt!=null)stmt.close();
			if(rs!=null)rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
