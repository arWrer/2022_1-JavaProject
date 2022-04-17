package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JavaProject extends JFrame{
	public JavaProject() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();

        c.setLayout(null);
		
        JLabel label1 = new JLabel("로그인");	
        label1.setLocation(35,30);
        label1.setSize(40,20);
        c.add(label1);
        
        JPanel idPanel = new JPanel();
        JLabel l1 = new JLabel(" I D  : ");
        JTextField jtid = new JTextField(10);
        idPanel.add(l1);
        idPanel.add(jtid);
        
        idPanel.setSize(200,30);
        idPanel.setLocation(10,80);
        
        JPanel pwPanel = new JPanel();
        JLabel l2 = new JLabel("PW : ");
        JTextField jtpw = new JTextField(10);
        
        pwPanel.add(l2);
        pwPanel.add(jtpw);
        
        pwPanel.setSize(200,30);
        pwPanel.setLocation(10,120);
        
        JPanel button = new JPanel();
        
        button.setSize(200,50);
        button.setLocation(19,180);
        
        JButton lbutton = new JButton("로그인");
        JButton sbutton = new JButton("회원 가입");
        
        sbutton.addActionListener(new ButtonAction(){
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		new SignUp();
        		
        	}
        });
        
        //lbutton.setLocation(10,160);
        button.add(lbutton);
        button.add(sbutton);
        
        
        
    
        
		
        
        c.add(idPanel);
        c.add(pwPanel);
        c.add(button);
        setSize(250, 350);//프레임 사이즈
		setVisible(true);
	}
	public static void main(String[] args) {
		new JavaProject();
	}
}
class ButtonAction implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		
	}
}

