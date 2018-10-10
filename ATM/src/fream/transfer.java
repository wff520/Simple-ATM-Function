package fream;
/*
 * 转账页面
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class transfer {
	public  static void transferFrame(String username,String password) {
	//创建窗体,并初始化，设置的组件布局均为无布局设置
    JFrame frame=new JFrame("富风银行");
   //创建 面板,设置面板布局为null
    JPanel  jpanel=new JPanel();
    jpanel.setLayout(null);
    jpanel.setBackground(Color.cyan);
    frame.add(jpanel);
    JLabel  jab1=new JLabel("请输入您转入的账户：");
    jab1.setFont(new Font("Dialog",1,19))	;
    jab1.setBounds(200,100,200,20);
    jpanel.add( jab1);
    JTextField jtf1=new JTextField();
    
    jtf1.setBounds(200,200,300,35);
    jpanel.add( jtf1);
    JLabel  jab2=new JLabel("转账金额：");
    jab2.setFont(new Font("Dialog",1,19))	;
    jab2.setBounds(200,300,100,20);
    jpanel.add( jab2);
    JTextField jtf2=new JTextField();
    jtf2.setBounds(200,400,300,35);
    jpanel.add( jtf2);
   
    //确认存款按钮 
    JButton sure=new JButton("确认");
    sure.setBounds(200,500,100,40);
    sure.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 			 String name=jtf1.getText();
 		    String accouts=jtf2.getText();
 			try {
 				
 				new ATMClient("5",username, password,accouts,name).start();
				String[] string=null;
				try {
					string = Dataparsing.dataparsing();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			 string[0]=string[0].trim();
				string[1]=string[1].trim();
				string[2]=string[2].trim();
				string[3]=string[3].trim();
				string[4]=string[4].trim();
				
				if(string[4].equals("转账成功")) {
					JOptionPane.showMessageDialog(null, "您转入账户为：为"+name+"转入金额为:"+accouts, "提示",JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
					Transaction.transactionframe(username,password);
				}
				else if(string[4].equals("您的余额不足")){
					JOptionPane.showMessageDialog(null, "您的余额不足", "提示",JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
					transferFrame( username,password);
				}
				else {
					JOptionPane.showMessageDialog(null, "没有该账户，请重新输入", "提示",JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
					transferFrame( username,password);
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}});
    jpanel.add(sure);
    JButton cancel=new JButton("取消");
    cancel.setBounds(600,500,100,40);
    cancel.addActionListener(new ActionListener () {
   		public void actionPerformed(ActionEvent arg0) {
   			frame.dispose();
   			Transaction.transactionframe(username,password);
   		}});
    jpanel.add(cancel);
    JframeUtil.frameProperty(frame,1000,800);
}
}