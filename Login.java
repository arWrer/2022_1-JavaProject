package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame{
	
	static JLabel l;
	static JTextField jtid;
	static JTextField jtpw;
	static JFrame jf;
	public Login() {
		jf = new JFrame();
		setTitle("Login");
		setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
	
		Container c = jf.getContentPane();

		c.setLayout(null);
    
		JLabel tl = new JLabel("로그인");
		tl.setLocation(148,30);
        tl.setSize(80,40);
        c.add(tl);
        
        JPanel idPanel = new JPanel();
        
        idPanel.setLayout(null);
        JLabel idl1 = new JLabel(" 아이디  : ");
        jtid = new JTextField(10);
        
        
        // 유효성 검사 var  = /(^[a-zA-Z0-9].{8,14}$)/;
        
        idl1.setBounds(10,10,100,30);
        jtid.setBounds(110,10,130,30);
        
        idPanel.add(idl1);
        idPanel.add(jtid);
        
        idPanel.setBounds(10,80,400,70);
        JPanel pwPanel1 = new JPanel();
        
        pwPanel1.setLayout(null);
        JLabel pwl1 = new JLabel(" 비밀번호  : ");
        jtpw = new JTextField(10);
        l = new JLabel("등록되지 않은 정보입니다");
        l.setBounds(110,0,150,90);
        pwl1.setBounds(10,0,100,30);
        jtpw.setBounds(110,0,130,30);
        pwPanel1.add(pwl1);
        pwPanel1.add(jtpw);
        pwPanel1.add(l);
        l.setVisible(false);
        pwPanel1.setBounds(10,150,400,50);
    
        JPanel button = new JPanel();
        button.setBounds(-15,250,400,50);
        
        JButton lbutton = new JButton("로그인");
        JButton sbutton = new JButton("회원가입");

        MyActionListener listener = new MyActionListener();
        lbutton.addActionListener(listener);
        sbutton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		SignUpPage signup = new SignUpPage();
        		signup.SignUpUi();
        	}
        });

        button.add(lbutton);
        button.add(sbutton);
        
        
        c.add(idPanel);
        c.add(pwPanel1);
        c.add(button);
       
        jf.setSize(400, 600);//프레임 사이즈
		jf.setVisible(true);
	}
}
class MyActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		ON o = new ON();
		
		ConnectUser cu = new ConnectUser();
		int a = cu.LoginMatch(Login.jtid.getText(),Login.jtpw.getText());
		if (a == 0) {
			
			if (MainUi.count3%2==0) {
				Login.jf.dispose();
				MainUi.count3++;
				MainUi.LoginTextSet("로그아웃");
				MainUi.LoginLebelSet(o.name);
			}
		}
		else {
			Login.l.setVisible(true);
			System.out.println("false");
		}
	}
}