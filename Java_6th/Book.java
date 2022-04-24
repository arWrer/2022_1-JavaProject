package swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Vector;

public class Book extends JFrame{
	public void BookUi() {
		setBounds(600, 400, 300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 260, 141);
		panel.add(scrollPane);
		
		JTable table = new JTable();
		scrollPane.setViewportView(table);
		
		Vector<String> columnNames = new Vector<String>(Arrays.asList("번호","제목","저자","상태"));
		DefaultTableModel dtm = new DefaultTableModel(columnNames,0);
		
		Vector rowData = new Vector();
		rowData.add(10011);
		rowData.add("푸른바다의 전설");
		rowData.add("강하늘");
		rowData.add("소설");
		
		dtm.addRow(rowData);
		table.setModel(dtm);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		Book book = new Book();
		book.BookUi();
	}
	
}
