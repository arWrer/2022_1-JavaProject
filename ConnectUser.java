package swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectUser {
	ON o = new ON();
	public static void UserInput(String id,String pw ,String name,int age, String sex , String genre, String book) {		//DB insert
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		try {
			con = Connect.getConnect();
			
			stmt = con.createStatement();

	
			String sql = "insert into user value('"+id+"','"+pw+"','"+name+"','"+age+"','"+sex+"','"+genre+"','"+book+"');";
			stmt.executeUpdate(sql);
			
			
			} catch (SQLException e) {
				System.out.println("SQL ���� = " + e.getMessage());
			} finally {
				Connect.close(con, stmt,rs);
			}
		}

	public int LoginMatch(String getid, String getpw) {		//DB select�� ���̵� �ߺ��˻�

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		
		try {
			con = Connect.getConnect();
			stmt = con.createStatement();
			String sql = "select * from user";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
	            String dbId = rs.getString("id");
	            String dbPw = rs.getString("pw");
	            String dbNm = rs.getString("name");
	            int dbmanager = rs.getInt("manager");
	            if (dbId.equals(getid) && dbPw.equals(getpw)) {
	            	ON o = new ON();
	            	o.setOn(dbNm,dbId,dbPw,dbmanager);
	            	return 0;
	            }
	            else   
	            	continue;
	         }
			return 1;
		} catch(SQLException e) {
			System.out.println("SQL ���� = " + e.getMessage());
		} finally {
			Connect.close(con, stmt, rs);
		}
		return 0;  // ������ 0 ��
	}
	public static int MatchId(String get) {		//DB select�� ���̵� �ߺ��˻�

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		System.out.println(get);
		try {
			con = Connect.getConnect();
			stmt = con.createStatement();
			String sql = "select * from user";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
	            String GetId = rs.getString("id");
	            if (GetId.equals(get)) 
	            	return 0;
	            else   
	            	continue;
	         }
			return 1;
		} catch(SQLException e) {
			System.out.println("SQL ���� = " + e.getMessage());
		} finally {
			Connect.close(con, stmt, rs);
		}
		return 0;
	}
	String title = "��";
	public int countSpNum() {		//title �����ͼ� �����ִ� user�� �뿩������ title ��ġ�°�

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		int num=0;
		try {
			con = Connect.getConnect();
			stmt = con.createStatement();
			String sql = "select book from user where id = '"+o.id+"'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
	            title = rs.getString("book");
	         }
			num = title.length() - title.replace(String.valueOf('��'), "").length();
		} catch(SQLException e) {
			System.out.println("getTitle SQL ���� = " + e.getMessage());
		} finally {
			Connect.close(con, stmt, rs);
		}
		return num;
	}
	
	String getTitle(String titleget) {		//title �����ͼ� �����ִ� user�� �뿩������ title ��ġ�°�

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			con = Connect.getConnect();
			stmt = con.createStatement();
			String sql = "select book from user where id = '"+o.id+"'";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
	            title = rs.getString("book");
	         }
			title = title.concat(titleget);
			title = title.concat("��");
		} catch(SQLException e) {
			System.out.println("getTitle SQL ���� = " + e.getMessage());
		} finally {
			Connect.close(con, stmt, rs);
		}
		return title;
	}

}
