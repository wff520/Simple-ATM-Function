package fream;
/*
 * 登录页面
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
	  //创建登录窗体,并初始化
         JFrame frame=new JFrame("富风银行");
        //创建 面板,设置面板布局为null
         JPanel  jpanel=new JPanel();
         jpanel.setLayout(null);
         jpanel.setBackground(Color.cyan);
         frame.add(jpanel);
         //用户名标签
         JLabel username=new JLabel("请输入您的卡号:");
         username.setBounds(300,200,200,20);
         username.setFont(new Font("Dialog",1,17));
         //用户名的输入框
        JTextField jtf=new JTextField();
          jtf.setBounds(450,200,220,30);
        jpanel.add(username);
       jpanel.add(jtf);
      //密码标签及输入框
        JLabel password=new JLabel("请输入您的密码:");
        password.setFont(new Font("Dialog",1,17));
        password.setBounds(300,300,200,20);
        JPasswordField jpf=new JPasswordField(15);
        jpf.setBounds(450,300,220,30);
       jpanel.add(password);
        jpanel.add(jpf);
      //读取卡号及密码内容，并发送至服务端确认。
        //取消按钮
        JButton cancel=new JButton("取消");
        cancel.setBounds(250,500,100,30);
        cancel.addActionListener(new ActionListener () {
			
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				welcome.welcomeframe();
			}});
        jpanel.add(cancel);
       
      //登录按钮
        JButton login=new JButton("登录");
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
						jop.showMessageDialog(null, "您输入密码错误或没有卡号存在", "提示",JOptionPane.PLAIN_MESSAGE);
						frame.dispose();
						loginframe.login();
				}
			}});
        jpanel.add(login);
        JframeUtil.frameProperty(frame,1000,800);
}
	
	
}