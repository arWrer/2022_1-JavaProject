package swing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
		new MainUi();
		/*
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = Connect.getConnect();
			stmt = con.createStatement();
			
			String sql ="select * from P_data";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String id = rs.getString("id"); 
				String pw  = rs.getString("pw");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				int sex = rs.getInt("sex");
				String genre = rs.getString("genre");
				System.out.println(id+"\t"+pw+"\t"+name+"\t"+age+"\t"+sex+"\t"+genre+"\t");
				
				
			}
			
		} catch(SQLException e) {
			System.out.println("SQL ¿À·ù = " + e.getMessage());
		} finally {
			Connect.close(con, stmt, rs);
	
		}
		
	*/
	}
}
