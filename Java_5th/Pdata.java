package swing;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class Pdata {
	
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
				System.out.println("SQL ¿À·ù = " + e.getMessage());
			} finally {
				Connect.close(con, stmt,rs);
			}
		}
}
