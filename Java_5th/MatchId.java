package swing;


import java.sql.*;

import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MatchId {
	
	static String q;

	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	

	public int MatchId1(String get) {
		try {
			con = Connect.getConnect();
			stmt = con.createStatement();
			String sql = "select * from P_data";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
	            String GetId = rs.getString("id");
	            if (GetId.equals(get)) {
	            	return 0;
	            }
	            else   
	            	return 1;
	         }

		} catch(SQLException e) {
			System.out.println("SQL ¿À·ù = " + e.getMessage());
		} finally {
			Connect.close(con, stmt, rs);
		}
		return 0;
	}

}
			


	