package swing;


import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectBook {
	
	public void BookInput(int num,String title,String author,String genre) {    // Book insert
		Connection con = null;
		Statement stmt = null;
		ResultSet rs =null;
		
		try {
			con = Connect.getConnect();
			stmt = con.createStatement();
			String sql = "insert into book value('"+num+"','"+title+"','"+author+"','"+genre+"');";
			stmt.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println("SQL 오류 = " + e.getMessage());
			} finally {
				Connect.close(con, stmt,rs);
			}
		}
	
	public int ReturnBookNum(int num) {			// 도서 등록할때 장르선택시 번호 자동으로 생성
		Connection con = null;
		Statement stmt = null;
		ResultSet rs =null;
		int returnNum = 0;
		try {
			con = Connect.getConnect();
			stmt = con.createStatement();
			String sql = "select max(num) from book where num like '"+num+"' '%';";
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				 String ptr = rs.getString("max(num)");
				 returnNum = Integer.parseInt(ptr);
			}
			} catch (SQLException e) {
				System.out.println("SQL 오류 = " + e.getMessage());
			} finally {
				Connect.close(con, stmt,rs);
			}
		return returnNum+1;
		}
	
	public int MatchNum(int num) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs =null;
		int returnNum = 1;
		try {
			con = Connect.getConnect();
			stmt = con.createStatement();
			String sql = "select num from book";
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				 String ptr = rs.getString("num");
				 if (num == Integer.parseInt(ptr)) {
					 returnNum = 0;
					 break;
				 }
			}
			} catch (SQLException e) {
				System.out.println("SQL 오류 = " + e.getMessage());
				return returnNum;
			} finally {
				Connect.close(con, stmt,rs);
			}
		
		return returnNum;
	}
	public int State(String num) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs =null;
		int state = 10;
		try {
			con = Connect.getConnect();
			stmt = con.createStatement();
			String sql = "select state from book where num = '"+ num +"'";			
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				state = rs.getInt("state");
			}
			return state;
		}
			 catch (SQLException e) {
				System.out.println("state SQL 오류 = " + e.getMessage());
			} finally {
				Connect.close(con, stmt,rs);
			}
		
		return 0;
	}
	
	
	public void delete(String a) {		//book 삭제

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		
		try {
			con = Connect.getConnect();
			stmt = con.createStatement();
			String sql = "delete from book where num = '"+ a +"' ";
			stmt.executeUpdate(sql);
			
		} catch(SQLException e) {
			System.out.println("SQL 오류 = " + e.getMessage());
		} finally {
			Connect.close(con, stmt, rs);
		}
		
	}

	
}
