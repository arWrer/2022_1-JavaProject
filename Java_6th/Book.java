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
		
		Vector<String> columnNames = new Vector<String>(Arrays.asList("��ȣ","����","����","����"));
		DefaultTableModel dtm = new DefaultTableModel(columnNames,0);
		
		Vector rowData = new Vector();
		rowData.add(10011);
		rowData.add("Ǫ���ٴ��� ����");
		rowData.add("���ϴ�");
		rowData.add("�Ҽ�");
		
		dtm.addRow(rowData);
		table.setModel(dtm);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		Book book = new Book();
		book.BookUi();
	}
	
}
