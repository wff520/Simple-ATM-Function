package fream;
/*
 * ��¼ҳ��
 */

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Group;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginframe {
	public static void login() {
	  //������¼����,����ʼ��
         JFrame frame=new JFrame("��������");
        //���� ���,������岼��Ϊnull
         JPanel  jpanel=new JPanel();
         jpanel.setLayout(null);
         jpanel.setBackground(Color.cyan);
         frame.add(jpanel);
         //�û�����ǩ
         JLabel username=new JLabel("���������Ŀ���:");
         username.setBounds(300,200,200,20);
         username.setFont(new Font("Dialog",1,17));
         //�û����������
        JTextField jtf=new JTextField();
          jtf.setBounds(450,200,220,30);
        jpanel.add(username);
       jpanel.add(jtf);
      //�����ǩ�������
        JLabel password=new JLabel("��������������:");
        password.setFont(new Font("Dialog",1,17));
        password.setBounds(300,300,200,20);
        JPasswordField jpf=new JPasswordField(15);
        jpf.setBounds(450,300,220,30);
       jpanel.add(password);
        jpanel.add(jpf);
      //��ȡ���ż��������ݣ��������������ȷ�ϡ�
        //ȡ����ť
        JButton cancel=new JButton("ȡ��");
        cancel.setBounds(250,500,100,30);
        cancel.addActionListener(new ActionListener () {
			
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				welcome.welcomeframe();
			}});
        jpanel.add(cancel);
       
      //��¼��ť
        JButton login=new JButton("��¼");
        login.setBounds(700,500,100,30);
         login.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent arg0) {
			String[] string=null;
			String name=null;
			String pw=null;
			try {
				name=jtf.getText();
				pw=String.valueOf(jpf.getPassword());
				new ATMClient("2",name,pw,"0","1").start();
				 string=Dataparsing.dataparsing(); 
				 string[0]=string[0].trim();
					string[1]=string[1].trim();
					string[2]=string[2].trim();
					string[3]=string[3].trim();
					string[4]=string[4].trim();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				if(string[4].equals("1")) {
					frame.dispose();
				Transaction.transactionframe(name,pw);
				}
				if(string[4].equals("2")||string[4].equals("3")) {
					 JOptionPane jop=new JOptionPane();
						jop.showMessageDialog(null, "��������������û�п��Ŵ���", "��ʾ",JOptionPane.PLAIN_MESSAGE);
						frame.dispose();
						loginframe.login();
				}
			}});
        jpanel.add(login);
        JframeUtil.frameProperty(frame,1000,800);
}
	
	
}