package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainUi extends JFrame{

	JButton []PanelBt = new JButton[12];
	String []ButtonName = {"자료검색","통합검색","인기자료","희망도서신청","내정보","대출정보","정보수정","희망도서신청내역","도서관정보","인삿말","연혁","도서관현황"};
			
	static int count = 0 , count1 = 0 ,count2 = 0;
	private Font f1 = new Font("돋움", Font.PLAIN, 30);
	private Font f2 = new Font("돋움", Font.PLAIN, 20);
	
	public MainUi() {
		setTitle("MainUi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();

        c.setLayout(null);
        
        JPanel Panel1 = new JPanel();
        JPanel Panel2 = new JPanel();
        JPanel Panel3 = new JPanel();
        
        Panel1.setLayout(null);
        Panel2.setLayout(null);
        Panel3.setLayout(null);
        for (int i=0;i<12;i++) {						// 메뉴선택번호 삽입, 설정
        	PanelBt[i] = new JButton(ButtonName[i]); 

        	PanelBt[i].setBorderPainted(false);  
            PanelBt[i].setFocusPainted(false);
            PanelBt[i].setContentAreaFilled(false);
        }
        for (int i=0;i<11;i+=4) {
            PanelBt[i].setFont(f1);
            PanelBt[i].setBounds(0,0,300,100);
            
        }
        
        int j=0;
        for(int i=0;i<12;i++) {
        	if (i%4==0)
        		continue;
        	PanelBt[i].setBounds(50,100+j,200,70);
        	j+=70;
        	if (j==210)
        		j=0;
        	PanelBt[i].setFont(f2);
        	PanelBt[i].setVisible(false);
        	
        }
        for (int i=0;i<12;i++) {
        	if(i<4)
        	 Panel1.add(PanelBt[i]);
        	else if (i<8 && i>3)
        	 Panel2.add(PanelBt[i]);
        	else
        	 Panel3.add(PanelBt[i]);
        }
        JLabel jlabel = new JLabel("s");
        c.add(jlabel);
        PanelBt[0].addActionListener(new ButtonAction(){
            public void actionPerformed(ActionEvent e) {
               
               
               if (count%2==1) {
                  for (int i=1;i<4;i++)
                     PanelBt[i].setVisible(false);
               }
               else if (count%2==0){
                  for (int i=1;i<4;i++)
                     PanelBt[i].setVisible(true);
               }
               count+=1;
               jlabel.setText(String.valueOf(count));
            }
         });
        
        PanelBt[4].addActionListener(new ButtonAction(){
            public void actionPerformed(ActionEvent e) {
               
               
               if (count1%2==1) {
                  for (int i=5;i<8;i++)
                     PanelBt[i].setVisible(false);
               }
               else if (count1%2==0){
                  for (int i=5;i<8;i++)
                     PanelBt[i].setVisible(true);
               }
               count1+=1;
               jlabel.setText(String.valueOf(count));
            }
         });
        
        PanelBt[8].addActionListener(new ButtonAction(){
            public void actionPerformed(ActionEvent e) {
               
               
               if (count2%2==1) {
                  for (int i=9;i<12;i++)
                     PanelBt[i].setVisible(false);
               }
               else if (count2%2==0){
                  for (int i=9;i<12;i++)
                     PanelBt[i].setVisible(true);
               }
               count2+=1;
               jlabel.setText(String.valueOf(count));
            }
         });
       
        jlabel.setBounds(0,0,100,50);
        Panel1.setBounds(450,150,300,400);
        c.add(Panel1);
        Panel2.setBounds(800,150,300,400);
        c.add(Panel2);
        Panel3.setBounds(1150,150,300,400);
        c.add(Panel3);
        
        JButton LoginBt = new JButton("로그인");
        LoginBt.setLayout(null);
        
        LoginBt.setBounds(1700,150,100,50);
        c.add(LoginBt);
        
        LoginBt.setBorderPainted(false);  
        LoginBt.setFocusPainted(false);
        LoginBt.setContentAreaFilled(false);
        
        LoginBt.addActionListener(new ButtonAction(){
            public void actionPerformed(ActionEvent e) {
            	new Login();
            }
         });

        setSize(1920,1200);//프레임 사이즈
        setVisible(true);
        
        Color color = new Color(0,128,0,30);
        Color color1 = new Color(0,128,0,10);
        
	}
}