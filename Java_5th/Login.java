package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame{
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		Container c = getContentPane();

		c.setLayout(null);
    
		JLabel tl = new JLabel("�α���");
		tl.setLocation(148,30);
        tl.setSize(80,40);
        c.add(tl);
        
        JPanel idPanel = new JPanel();
        
        idPanel.setLayout(null);
        JLabel idl1 = new JLabel(" ���̵�  : ");
        JTextField jtid = new JTextField(10);
        
        // ��ȿ�� �˻� var  = /(^[a-zA-Z0-9].{8,14}$)/;
        
        idl1.setBounds(10,10,100,30);
        jtid.setBounds(110,10,130,30);
        
        idPanel.add(idl1);
        idPanel.add(jtid);
        
        idPanel.setBounds(10,80,400,70);
    
        
        
        JPanel pwPanel1 = new JPanel();
        
        pwPanel1.setLayout(null);
        JLabel pwl1 = new JLabel(" ��й�ȣ  : ");
        JTextField jtpw = new JTextField(10);
        
        
        pwl1.setBounds(10,0,100,30);
        jtpw.setBounds(110,0,130,30);
        pwPanel1.add(pwl1);
        pwPanel1.add(jtpw);
        
        
        pwPanel1.setBounds(10,150,400,50);
    
        JPanel button = new JPanel();
        button.setBounds(-15,250,400,50);
        
        JButton lbutton = new JButton("�α���");
        JButton sbutton = new JButton("ȸ������");
        
        lbutton.addActionListener(new ButtonAction(){
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		
        		
        	}
        });
        sbutton.addActionListener(new ButtonAction(){
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
       
        setSize(400, 600);//������ ������
		setVisible(true);
	}
	
}