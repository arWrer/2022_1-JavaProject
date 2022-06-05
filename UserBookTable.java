package swing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class UserBookTable {
	
	ON o = new ON();
	Book B = new Book();
	ConnectUser CU = new ConnectUser();
	public void insertUserBook(String ptr) {		//user가 빌린 책 삽입메소드
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		try {
			con = Connect.getConnect();
			stmt = con.createStatement();
			String sql = "update user set book = '"+ptr+"' where id = '"+o.id+"' ";
			stmt.executeUpdate(sql);
			
			
			} catch (SQLException e) {
				System.out.println("insertUserBook SQL 오류 = " + e.getMessage());
			} finally {
				Connect.close(con, stmt,rs);
			}
		}
	public void updateState(int num ,String title) {		//빌리면 대여못하게 상태를 1로 업데이트
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		try {
			con = Connect.getConnect();
			stmt = con.createStatement();
			String sql = "update book set state = '"+num+"' where title = '"+title+"'";
			stmt.executeUpdate(sql);
			
			
			} catch (SQLException e) {
				System.out.println("insertUserBook SQL 오류 = " + e.getMessage());
			} finally {
				Connect.close(con, stmt,rs);
			}
		}
	
	public String[] getUserBook() {
		
		
		Connect connect = new Connect();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs =null;
		
		String bookname = null;
		String[] array = null;

		try {
			con = Connect.getConnect();
			stmt = con.createStatement();
			String sql = "select book from user where id = '"+o.id+"'";
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				 bookname = rs.getString("book");
			}
			array = bookname.split("§");
			} catch (SQLException e) {
				System.out.println("SQL 오류 = " + e.getMessage());
				
			} finally {
				Connect.close(con, stmt,rs);
			}
		return array;
		
		}
	void ViewUserTable(String[] array) {
		
		
		Connect connect = new Connect();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs =null;
		int n = CU.countSpNum();
		Book.rentNum.setText(o.name+"님 대여가능권수 :"+(6-n));
		
		
		DefaultTableModel Bmodel = (DefaultTableModel)Book.Utable.getModel();
		Bmodel.setNumRows(0);
		
		try {
			con = Connect.getConnect();
			
			stmt = con.createStatement();

			for (int i=0;i<array.length;i++) {
				rs = stmt.executeQuery("select * from book where title = '"+array[i]+"'");
				while (rs.next()) {
					int num = rs.getInt("num");
					String title = rs.getString("title");
					String author = rs.getString("author");
					String genre = rs.getString("genre");
					Vector rowData = new Vector();  //insert
					rowData.add(num);
					rowData.add(title);
					rowData.add(author);
					rowData.add(genre);
					
					B.Udtm.addRow(rowData);
					
				}	
			}
			} catch (SQLException e) {
				System.out.println("SQL 오류 = " + e.getMessage());
			} finally {
				Connect.close(con, stmt,rs);
			}
		
	}
	String returnBookName() {
		
		Connect connect = new Connect();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs =null;
		String book = null;
		try {
			con = Connect.getConnect();
			stmt = con.createStatement();
			String sql = "select book from user where id = '"+o.id+"'";
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				 book = rs.getString("book");
			}
			
			} catch (SQLException e) {
				System.out.println("SQL 오류 = " + e.getMessage());
				
			} finally {
				Connect.close(con, stmt,rs);
			}
		return book;
		
		}
}
