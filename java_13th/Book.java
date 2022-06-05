package swing;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Vector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Book extends JFrame{
	
	ConnectBook connectB = new ConnectBook();
	ConnectUser connectU = new ConnectUser();
	ON o =new ON();
	JButton []bt= new JButton[6];
	String []ButtonName = {"검색","대출","반납","도서추가","도서삭제","새로고침"};
	JRadioButton []chk = new JRadioButton[9];
	JTextField jtnb,jttt,jtat,t;
	static JLabel rentNum;
    static int row,col,row1,col1;
    static JTable booktable,Utable;
	static DefaultTableModel dtm,Udtm;
	
	String [] list = {"도서번호","제목","저자","장르","상태"};
	JComboBox<String> strCombo = new JComboBox<String>(list);

	public void BookUi() {
		
		JFrame frame1 = new JFrame();
		frame1.setTitle("도서정보");
		frame1.setBounds(400, 300, 1030, 500);
		frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		Container c = frame1.getContentPane();
		c.setLayout(null);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 400, 400);
		panel.add(scrollPane);
		
		c.add(scrollPane);
		booktable = new JTable();
		Utable = new JTable();
		scrollPane.setViewportView(booktable);
		
		
		Vector<String> columnNames = new Vector<String>(Arrays.asList("번호","제목","저자","장르",""));
		dtm = new DefaultTableModel(columnNames,0);
		
		
		int j=0;
		for (int i=0;i<6;i++) {
			
			bt[i] = new JButton(ButtonName[i]);
			bt[i].setBounds(450,10+j,100,50);
			j=j+70;
		}
		//JButton 
		for(int i=0;i<6;i++) 
			c.add(bt[i]);
		
		
		booktable.addMouseListener(new MyMouseListener());
		Utable.addMouseListener(new MyMouseListener());
		bt[0].addActionListener(new BookSearch());
		bt[1].addActionListener(new BookBorrow());
		bt[2].addActionListener(new BookReturn());
		bt[3].addActionListener(new BookEnroll());
		bt[4].addActionListener(new BookDelete());
		bt[5].addActionListener(new Reload());	
		
		rentNum = new JLabel("");
		rentNum.setBounds(800,100,200,50);
		c.add(rentNum);
		
		JPanel Upanel = new JPanel();
		getContentPane().add(Upanel, BorderLayout.CENTER);	
		Upanel.setLayout(null);
		
		JScrollPane UscrollPane = new JScrollPane();
		UscrollPane.setBounds(592, 150, 400, 260);
		Upanel.add(UscrollPane);
		
		
		c.add(UscrollPane);
		UscrollPane.setViewportView(Utable);
	
		Vector<String> UcolumnNames = new Vector<String>(Arrays.asList("번호","제목","저자","장르"));
		Udtm = new DefaultTableModel(UcolumnNames,0){
			public boolean isCellEditable(int i, int c)
			{
				return false;
			 	}
		};
		booktable.setModel(dtm);
		Utable.setModel(Udtm);
		
		booktable.getColumnModel().getColumn(0).setPreferredWidth(40);  //JTable 의 컬럼 길이 조절
		booktable.getColumnModel().getColumn(1).setPreferredWidth(170);
		booktable.getColumnModel().getColumn(2).setPreferredWidth(130);
		booktable.getColumnModel().getColumn(3).setPreferredWidth(60);
		booktable.getColumnModel().getColumn(4).setPreferredWidth(10);
		Utable.getColumnModel().getColumn(0).setPreferredWidth(40);  //JTable 의 컬럼 길이 조절
		Utable.getColumnModel().getColumn(1).setPreferredWidth(170);
		Utable.getColumnModel().getColumn(2).setPreferredWidth(130);
		Utable.getColumnModel().getColumn(3).setPreferredWidth(60);
		
		frame1.setVisible(true);
	}
	
	void ViewTable(String str) {
		
		ON o = new ON();
		int n = connectU.countSpNum();
		rentNum.setText(o.name+"님 대여가능권수 :"+(6-n));
		Connect connect = new Connect();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs =null;
		
		DefaultTableModel model = (DefaultTableModel)booktable.getModel();
		model.setNumRows(0);
	
		char able; 
		try {
			con = Connect.getConnect();
			
			stmt = con.createStatement();

	
			//String sql = "select * from book";
			String sql = ""+str+"";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String genre = rs.getString("genre");
				int state = rs.getInt("state");
				if (state == 0)
					able = 'O';
				else
					able = 'X';
				
				Vector rowData = new Vector();  //insert
				rowData.add(num);
				rowData.add(title);
				rowData.add(author);
				rowData.add(genre);
				rowData.add(able);
				
				dtm.addRow(rowData);

			}		
			
			} catch (SQLException e) {
				System.out.println("SQL 오류 = " + e.getMessage());
			} finally {
				Connect.close(con, stmt,rs);
			}
		
		}
	private class MyMouseListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == 1) {
				 	row = booktable.getSelectedRow();
				 	col = booktable.getSelectedColumn();
				 	row1 = Utable.getSelectedRow();
					col1 = Utable.getSelectedColumn();
				}
			if (e.getClickCount() == 2) {
				System.out.println("120394289295");
			}
		}
	}

	private class BookSearch implements ActionListener{  //도서검색 버튼 누를시 진행되는 이벤트
		@Override
		public void actionPerformed(ActionEvent e) {
			SearchUi();			
		}		
	}
	private class BookBorrow implements ActionListener{  //대출버튼 누를시 진행되는 이벤트
		@Override
		public void actionPerformed(ActionEvent e) {	
			
			if (!o.id.equals(null)) {
				bookBorrowEx();
		}
		}
	}
	private class BookReturn implements ActionListener{  // 반납버튼 누를시 진행되는 이벤트
		@Override
		public void actionPerformed(ActionEvent e) {	
			bookReturnEx();
			
		}		
	}
	private class BookEnroll implements ActionListener{  //도서등록 버튼 누를시 진행되는 이벤트
		@Override
		public void actionPerformed(ActionEvent e) {
			if (o.manager == 1)
				EnrollUi();			
		}		
	}
	private class BookDelete implements ActionListener{  //도서삭제 버튼 누를시 진행되는 이벤트
		@Override
		public void actionPerformed(ActionEvent e) {
			// 누른 갑가져오기 row col
			// 삭제
			if (o.manager == 1) {
				String num = booktable.getModel().getValueAt(row,0).toString();
				connectB.delete(num);
				ViewTable("select * from book");
			}
		}
		
	}
	private class Reload implements ActionListener{  //새로고침 버튼 누를시 진행되는 이벤트
		@Override
		public void actionPerformed(ActionEvent e) {
			UserBookTable UBT = new UserBookTable();
			ViewTable("select * from book");
			String[] array = UBT.getUserBook();
			UBT.ViewUserTable(array);
		}
		
	}
	void SearchUi() {
		JFrame frame = new JFrame();
		frame.setTitle("도서검색");
		frame.setBounds(400, 300, 400,100);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Container c = frame.getContentPane();
		FlowLayout f= new FlowLayout();
		JLabel l = new JLabel("검색 :");
		JButton b = new JButton("검색");
		t = new JTextField(10);
		b.addActionListener(new Search());

		c.setLayout(f);
		c.add(strCombo);
		c.add(l);
		c.add(t);
		c.add(b);
		frame.setVisible(true);
	}
	private class Search implements ActionListener{  //도서삭제 버튼 누를시 진행되는 이벤트
		@Override
		public void actionPerformed(ActionEvent e) {
			String kind = strCombo.getSelectedItem().toString();
			String str = t.getText();
			if (list[0].equals(kind)) {
				ViewTable("select * from book where num like '%"+str+"%'");
			}
			else if (list[1].equals(kind)) {
				ViewTable("select * from book where title like '%"+str+"%'");
			}
			else if (list[2].equals(kind)) {
				ViewTable("select * from book where author like '%"+str+"%'");
			}
			else if (list[3].equals(kind)) {
				ViewTable("select * from book where genre like '%"+str+"%'");
			}
			else if (list[4].equals(kind)) {
				ViewTable("select * from book where state like '%"+str+"%'");
			}
		}
	}
	void EnrollUi() {
		JFrame frame2 = new JFrame();
		frame2.setTitle("SignUp");
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		Container c2 = frame2.getContentPane();

		c2.setLayout(null);
    
		JLabel tl = new JLabel("도서등록");
		tl.setLocation(148,30);
        tl.setSize(80,40);
        c2.add(tl);
        
        JPanel Panel1 = new JPanel();
        jtnb = new JTextField(5);
        Panel1.setLayout(null);
        
        JLabel nbl1 = new JLabel(" 번 호  : ");
        nbl1.setBounds(10,10,100,30);
        jtnb.setBounds(110,15,50,30);
        
        JLabel nbl2 = new JLabel("중복된 도서번호입니다");
        nbl2.setBounds(165,13,200,30);
        nbl2.setVisible(false);
        
        Panel1.add(nbl1);
        Panel1.add(nbl2);
        Panel1.add(jtnb);
        
        JLabel ttl1 = new JLabel(" 제 목  : ");
        jttt = new JTextField(40);
        
        ttl1.setBounds(10,45,100,30);
        jttt.setBounds(110,45,200,30);
        Panel1.add(ttl1);
        Panel1.add(jttt);
        
        JLabel atl1 = new JLabel(" 저 자  : ");
        jtat = new JTextField(20);
        atl1.setBounds(10,80,100,30);
        jtat.setBounds(110,80,200,30);
        
        Panel1.add(atl1);
        Panel1.add(jtat);
         
        
        Panel1.setBounds(10,80,400,120);
        
        JPanel Panel2 = new JPanel();    //checkbox를 감싸는 panel2
        
        Panel2.setLayout(null);
        Panel2.setBounds(10,200,400,160);
        
        
        String []str = {"철학","종교","사회과학","자연과학","기술과학","예술","언어","문학","역사"};
        
        JLabel bk = new JLabel("도서 장르 :");
        bk.setBounds(10,0,100,30);
        ButtonGroup  group = new ButtonGroup();
        
        for(int i=0;i<9;i++) {
        	chk[i]=new JRadioButton(str[i]);
        	group.add(chk[i]);
        	chk[i].addItemListener(new MyItemListener());
        }
        int j=0,k=0;
        for (int i=0;i<9;i++) {
        	
        	chk[i].setBounds(105+j,k,80,30);
        	j+=80;
        	if (j>230) {
        		j=0;
        		k+=40;
        	}
       
        }
	    
	    Panel2.add(bk);
	    for (int i=0;i<9;i++) {
	    Panel2.add(chk[i]);
	    
	    }
	    
        
        JPanel button = new JPanel();
        button.setBounds(-15,410,400,50);
        
        JButton nbutton = new JButton("도서등록");
        JButton rbutton = new JButton("새로입력");
        
        nbutton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int num = Integer.parseInt(jtnb.getText());
        		String title = jttt.getText();
        		String author = jtat.getText();
        		String genre = GenreReturn(chk);
        		int match = connectB.MatchNum(num);
        		if (match == 1) {
        			connectB.BookInput(num,title,author,genre);
        			frame2.dispose();
            		ViewTable("select * from book");
        		}
        		else 
        			nbl2.setVisible(true);
        	}
        });
        rbutton.addActionListener(new ActionListener(){
        	
        	public void actionPerformed(ActionEvent e) {
        		
        		jtnb.setText("");
        		jttt.setText("");
        		jtat.setText("");
        		//rd1.setSelected(true);
        		
        		for (int i=0;i<9;i++) {
        			chk[i].setSelected(false);
        		    }
        		
        	}
        });

        button.add(nbutton);
        button.add(rbutton);
        
        c2.add(button);
        c2.add(Panel1);
        c2.add(Panel2);
        frame2.setSize(400, 600);//프레임 사이즈
        frame2.setVisible(true);
	}
	
	public String GenreReturn(JRadioButton chk[]) {
		String genre;
		for (int i=0;i<9;i++) {
    		if (chk[i].isSelected()) {
    			genre = chk[i].getText();
    			return genre;
    			
    		}
    	}
		return null;
	}
	class MyItemListener implements ItemListener{
		int num=0;
        @Override
        public void itemStateChanged(ItemEvent e) { 
        	for (int i=0;i<9;i++) {
        		if(chk[i].isSelected()){
                	num = connectB.ReturnBookNum(i+1);
                	jtnb.setText(Integer.toString(num));
                }
            }
        }
	}

	public void bookBorrowEx() {
		UserBookTable UBT = new UserBookTable();
		String num = booktable.getModel().getValueAt(row,0).toString();
		int able = connectB.State(num);
		String title = booktable.getModel().getValueAt(row,1).toString();
		String ptr = connectU.getTitle(title);
		int checknum = ptr.length() - ptr.replace(String.valueOf('§'), "").length();
		if (able == 0 && checknum <=6) {
			UBT.insertUserBook(ptr);
			UBT.updateState(1,title);
			String[] array = UBT.getUserBook();
			UBT.ViewUserTable(array);
			ViewTable("select * from book");
		}
	}
	
	public void bookReturnEx() {
		UserBookTable UBT = new UserBookTable();
		String pick = Utable.getModel().getValueAt(row1,1).toString();
		String pickbook = pick;
		pickbook = pickbook+'§';
		String title = UBT.returnBookName();
		title = title.replace(pickbook,"");
		UBT.insertUserBook(title);
		UBT.updateState(0,pick);
		String[] array = UBT.getUserBook();
		UBT.ViewUserTable(array);
		ViewTable("select * from book");
	}
	
}

