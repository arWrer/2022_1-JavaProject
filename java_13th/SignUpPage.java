package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class SignUpPage{
	
	JLabel idl2,pwl1;
	
	JOptionPane message;

	
	JCheckBox []chk = new JCheckBox[9];
	
	String []str = {"철학","종교","사회과학","자연과학","기술과학","예술","언어","문학","역사"};
	
	String Pm,getid,getpw,getnm,getse;
	int n;
	String genre="";
	
	Connect connect = new Connect();
	
	public boolean isGoodId(String str) {
	    return Pattern.matches("[a-zA-Z0-9].{7,14}$", str);
	}
	
	public void SignUpUi() {
		JFrame frame = new JFrame();
		frame.setTitle("SignUp");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		Container c = frame.getContentPane();

		c.setLayout(null);
    
		JLabel tl = new JLabel("기본정보입력");
		tl.setLocation(148,30);
        tl.setSize(80,40);
        c.add(tl);
        
        JPanel idPanel = new JPanel();
        
        idPanel.setLayout(null);
        JLabel idl1 = new JLabel(" 아이디  : ");
        JTextField jtid = new JTextField(10);
        JButton idm = new JButton("중복확인"); 
        
        
        
        
        idl2 = new JLabel("");
        
        
        
        idl1.setBounds(10,10,100,30);
        jtid.setBounds(110,10,130,30);
        idm.setBounds(243,10,90,30);
        idl2.setBounds(107,42,130,30);
        idPanel.add(idl1);
        idPanel.add(jtid);
        idPanel.add(idm);
        idPanel.add(idl2);
        
        idPanel.setBounds(10,80,400,70);
    
        
        
        JPanel pwPanel1 = new JPanel();
        
        pwPanel1.setLayout(null);
        JLabel pwl1 = new JLabel(" 비밀번호  : ");
        JTextField jtpw = new JTextField(10);
        
        
        pwl1.setBounds(10,0,100,30);
        jtpw.setBounds(110,0,130,30);
        pwPanel1.add(pwl1);
        pwPanel1.add(jtpw);
        
        
        pwPanel1.setBounds(10,150,400,50);
        
        JPanel pwPanel2 = new JPanel();
        
        pwPanel2.setLayout(null);
        JLabel pwl2 = new JLabel(" 비밀번호 확인  : ");
        JTextField jtpw2 = new JTextField(10);
        
        
        pwl2.setBounds(10,0,100,30);
        jtpw2.setBounds(110,0,130,30);
        pwPanel2.add(pwl2);
        pwPanel2.add(jtpw2);
        
        
        pwPanel2.setBounds(10,200,400,50);
        
        
        JPanel button = new JPanel();
        button.setBounds(-15,250,400,50);
        
        JButton nbutton = new JButton("다음");
        JButton rbutton = new JButton("새로 입력");
        
        idm.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		//new MatchId();
        		
        		
        		n=ConnectUser.MatchId(jtid.getText());
        		System.out.print(n);
        		
        		if (isGoodId(jtid.getText())) {
        			if (n==0) {
        				idl2.setText("중복된 아이디입니다.");
        			}
        			else {
        				idl2.setText("아이디 사용가능");
        			}	
        		}
        		else {
        			idl2.setText("아이디는 8~14글자로 입력해주십시오");
        		}
        	}
        });
        
        
        
        message = new JOptionPane();
        
        nbutton.addActionListener(new ActionListener(){	
        	public void actionPerformed(ActionEvent e) {
        		getid = jtid.getText();
        		getpw = jtpw.getText();
        		if (n==0) {
        			JOptionPane.showMessageDialog(null, "중복검사를 완료해주세요","ERROR", n);
        		}
        		else if (n==1) {
        			frame.dispose();
        			SignUp2(getid,getpw);
        		}
        	}
        });

        button.add(nbutton);
        button.add(rbutton);
        
        
        c.add(idPanel);
        c.add(pwPanel1);
        c.add(pwPanel2);
        c.add(button);
       
        frame.setSize(400, 600);//프레임 사이즈
		frame.setVisible(true);
	}
	public void SignUp2(String getid,String getpw) {
		
		
		
		Connect connect = new Connect();
		
		JFrame frame2 = new JFrame();
		System.out.println(getid);
		frame2.setTitle("SignUp");
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		Container c2 = frame2.getContentPane();

		c2.setLayout(null);
    
		JLabel tl = new JLabel("추가정보입력");
		tl.setLocation(148,30);
        tl.setSize(80,40);
        c2.add(tl);
        
        JPanel Panel1 = new JPanel();
        
        Panel1.setLayout(null);
        JLabel nml1 = new JLabel(" 이 름  : ");
        JTextField jtnm = new JTextField(10);
        
        nml1.setBounds(10,10,100,30);
        jtnm.setBounds(110,10,130,30);
        Panel1.add(nml1);
        Panel1.add(jtnm);
        
        JLabel agl1 = new JLabel(" 나 이  : ");
        JTextField jtag = new JTextField(10);
        
        agl1.setBounds(10,45,100,30);
        jtag.setBounds(110,45,50,30);
        Panel1.add(agl1);
        Panel1.add(jtag);
         
        
        Panel1.setBounds(10,80,400,120);
        
        JLabel sel1 = new JLabel(" 성 별 : ");
        
        sel1.setBounds(10,80,100,30);
        Panel1.add(sel1);
        
        JRadioButton rd1 = new JRadioButton("남");
        JRadioButton rd2 = new JRadioButton("여");

        JRadioButton rd3 = new JRadioButton("");  //라디오버튼을 초기화하기위한 공백의 라디오버튼
        
        // 라디오 버튼을 그룹화 하기위한 객체 생성
        ButtonGroup groupRd = new ButtonGroup();
        
        // 그룹에 라디오 버튼 포함시킨다.
        groupRd.add(rd1);
        groupRd.add(rd2);
        groupRd.add(rd3);
        rd1.setBounds(115,160,50,30);
        rd2.setBounds(165,160,50,30);
               
        JPanel Panel2 = new JPanel();    //checkbox를 감싸는 panel2
        
        Panel2.setLayout(null);
        Panel2.setBounds(10,200,400,160);
        
        JLabel bk = new JLabel("도서 장르 :");
        bk.setBounds(10,0,100,30);
        chk[0] = new JCheckBox("철학");
        for(int i=0;i<9;i++) {
        	chk[i]=new JCheckBox(str[i]);
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
        
        JButton nbutton = new JButton("회원가입");
        JButton rbutton = new JButton("새로입력");
        
        nbutton.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		getnm = jtnm.getText();
            	int getag = Integer.parseInt(jtag.getText());
            	if (rd1.isSelected() == true)
            		getse = rd1.getText();
            	else if (rd2.isSelected() == true)
            		getse = rd2.getText();
            	
        		genre = GenreReturn(chk);
        		
        		ConnectUser.UserInput(getid,getpw,getnm,getag,getse,genre,null);  // DB에 사람정보 등록
        		
        		frame2.dispose();
        	}
        });
        rbutton.addActionListener(new ActionListener(){
        	
        	public void actionPerformed(ActionEvent e) {
        		
        		//jtnm.setText("");
        		jtnm.setText("");
        		jtag.setText("");
        		//rd1.setSelected(true);
        		rd3.setSelected(true);
        		for (int i=0;i<9;i++) {
        			chk[i].setSelected(false);
        		    }
        		
        	}
        });

        button.add(nbutton);
        button.add(rbutton);
        
        c2.add(button);

        
        c2.add(rd1);
        c2.add(rd2);
        
        
        c2.add(Panel1);
        c2.add(Panel2);
        frame2.setSize(400, 600);//프레임 사이즈
        frame2.setVisible(true);
	}
	public String GenreReturn(JCheckBox chk[]) {
		for (int i=0;i<9;i++) {
    		if (chk[i].isSelected()) {
    			genre+=chk[i].getText()+",";
    		}
    	}
		return genre;
	}


	
}