package fream;
/*
 * ����ҳ�棬�����ø��ֹ��ܰ�ť
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Transaction {
	public static void transactionframe(String username,String password) {
	
	//��������
    JFrame frame=new JFrame("��������");
   //���� ��壬�����������Ϊnull
    JPanel  jpanel=new JPanel();  
    jpanel.setLayout(null );
    jpanel.setBackground(Color.cyan);
    //�������
    frame.add(jpanel);
    //������Ŀ��ǩ
    JLabel name=new JLabel("����Ҫ���Ľ���");
    name.setFont(new Font("Dialog",1,22))	;
   name.setBounds(400,100,200,20);
   jpanel.add(name);
  //��ѯ��ť
    JButton checkbalance=new JButton("��ѯ���");
    checkbalance.setBounds(200,250,100,40);
    checkbalance.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 			String[] string=null;
 			try {
 				new ATMClient("3",username, password,"���","��ѯ���").start();
 				 string=Dataparsing.dataparsing(); 
				 string[0]=string[0].trim();
					string[1]=string[1].trim();
					string[2]=string[2].trim();
					string[3]=string[3].trim();
					string[4]=string[4].trim();
					JOptionPane jop=new JOptionPane();
		 			jop.showMessageDialog(null, "�𾴵��û���"+username+"\n�������Ϊ��"+string[3], "��ʾ",JOptionPane.PLAIN_MESSAGE); 
		 			frame.dispose();
		 			transactionframe( username, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}});
    jpanel.add(checkbalance);
    //ת�˰�ť 
    JButton transferbt=new JButton("ת��");
    transferbt.setBounds(200,350,100,40);
    transferbt.addActionListener(new ActionListener () {
 		
 		public void actionPerformed(ActionEvent arg0) {
 			frame.dispose();
 			transfer.transferFrame(username,password);
 		}});
    jpanel.add( transferbt);
    //��ť 
    JButton depositbt=new JButton("���");
    depositbt.setBounds(200,450,100,40);
    depositbt.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 			frame.dispose();
 			deposit.depositFrame( username, password);
 		}});
    //ȡ�ť
    jpanel.add( depositbt);
JButton withdrawalbt=new JButton("ȡ��");
   withdrawalbt.setBounds(650,250,100,40);
      withdrawalbt.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 			frame.dispose();
 			withdrawalFrame.withdrawalframe(username, password);
 			
 		}});
      jpanel.add( withdrawalbt);
      //�޸�����
JButton Checkbalance=new JButton("�޸�����");
Checkbalance.setBounds(650,350,100,40);
    Checkbalance.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 			frame.dispose();
 			changepasswordFrame.changepasswordframe( username, password);
 		}});
    jpanel.add( Checkbalance);
JButton exitSystem=new JButton("�˳�");
exitSystem.setBounds(450,550,100,40);
exitSystem.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 			frame.dispose();
 			welcome.welcomeframe();
 			
 		}});
jpanel.add( exitSystem);
   JframeUtil.frameProperty(frame,1000,800);
}
	
}
