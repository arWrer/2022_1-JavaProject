package swing;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class JTableTest02 extends JFrame {

	JTable table;
	JScrollPane jsp;
	Vector<String> columnNames;
	Vector<Vector<String>> rowData;
	

	
	JTableTest02()
	{
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		Container c = getContentPane();
		c.setLayout(null);
		
		JPanel ScrollPane = new JPanel();
        
        ScrollPane.setLayout(null);
		
        setLayout(null);

		
		columnNames=new Vector<String>();
		rowData=new Vector<Vector<String>>();
		
		Vector<String> v =new Vector<String>();
		
		v.add("10035");
		v.add("채쫑의 일기");
		v.add("채경원");
		v.add("대여가능");
		rowData.add(v);
		
		v =new Vector<String>();
		v.add("12314");
		v.add("어느날 머리에서 뿔잉 자랐다");
		v.add("txt");
		v.add("대여 불가");
		rowData.add(v);
		
		columnNames.add("번호");
		columnNames.add("제목");
		columnNames.add("저자");
		columnNames.add("상태");
	 	
		table=new JTable(rowData, columnNames);
		table.getColumn("번호").setPreferredWidth(20);
		table.getColumn("제목").setPreferredWidth(100);
		
	 	jsp = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	 	//jsp.setLocation(0,0);
	 	jsp.setPreferredSize(new Dimension(600,400));
		table.setFillsViewportHeight(true);
		//add(jsp, BorderLayout.NORTH);
		frame.add(jsp);
		table.addMouseListener(new MyMouseListener());
		
		table.updateUI();
		ScrollPane.setBackground(Color.GREEN);
		ScrollPane.add(table);
		//c.add(ScrollPane);
		setVisible(true);
		setSize(1920,1280);
		

		}
	class MyMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			int selection = table.getSelectedRow();
			Vector<String> vc = rowData.get(selection);
			System.out.println(vc.get(0));
			System.out.println(vc.get(1));
			System.out.println(vc.get(2));
			System.out.println(vc.get(3));
		}
	}
		
	public static void main(String[] args) 
	{
		 new JTableTest02();
	}

}
		
		
		