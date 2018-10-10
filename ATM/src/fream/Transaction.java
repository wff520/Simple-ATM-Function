package fream;
/*
 * 交易页面，并设置各种功能按钮
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
	
	//创建窗体
    JFrame frame=new JFrame("富风银行");
   //创建 面板，并设置其面板为null
    JPanel  jpanel=new JPanel();  
    jpanel.setLayout(null );
    jpanel.setBackground(Color.cyan);
    //加入面板
    frame.add(jpanel);
    //交易项目标签
    JLabel name=new JLabel("请需要您的交易");
    name.setFont(new Font("Dialog",1,22))	;
   name.setBounds(400,100,200,20);
   jpanel.add(name);
  //查询余额按钮
    JButton checkbalance=new JButton("查询余额");
    checkbalance.setBounds(200,250,100,40);
    checkbalance.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 			String[] string=null;
 			try {
 				new ATMClient("3",username, password,"余额","查询余额").start();
 				 string=Dataparsing.dataparsing(); 
				 string[0]=string[0].trim();
					string[1]=string[1].trim();
					string[2]=string[2].trim();
					string[3]=string[3].trim();
					string[4]=string[4].trim();
					JOptionPane jop=new JOptionPane();
		 			jop.showMessageDialog(null, "尊敬的用户："+username+"\n您的余额为："+string[3], "提示",JOptionPane.PLAIN_MESSAGE); 
		 			frame.dispose();
		 			transactionframe( username, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}});
    jpanel.add(checkbalance);
    //转账按钮 
    JButton transferbt=new JButton("转账");
    transferbt.setBounds(200,350,100,40);
    transferbt.addActionListener(new ActionListener () {
 		
 		public void actionPerformed(ActionEvent arg0) {
 			frame.dispose();
 			transfer.transferFrame(username,password);
 		}});
    jpanel.add( transferbt);
    //存款按钮 
    JButton depositbt=new JButton("存款");
    depositbt.setBounds(200,450,100,40);
    depositbt.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 			frame.dispose();
 			deposit.depositFrame( username, password);
 		}});
    //取款按钮
    jpanel.add( depositbt);
JButton withdrawalbt=new JButton("取款");
   withdrawalbt.setBounds(650,250,100,40);
      withdrawalbt.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 			frame.dispose();
 			withdrawalFrame.withdrawalframe(username, password);
 			
 		}});
      jpanel.add( withdrawalbt);
      //修改密码
JButton Checkbalance=new JButton("修改密码");
Checkbalance.setBounds(650,350,100,40);
    Checkbalance.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 			frame.dispose();
 			changepasswordFrame.changepasswordframe( username, password);
 		}});
    jpanel.add( Checkbalance);
JButton exitSystem=new JButton("退出");
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
