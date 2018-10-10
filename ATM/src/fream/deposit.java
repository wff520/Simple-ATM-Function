package fream;
//存款功能实现
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

public class deposit {
public static void depositFrame(String username,String password) {
	//创建登录窗体,并初始化
    JFrame frame=new JFrame("富风银行");
   //创建 面板,设置面板布局为null
    JPanel  jpanel=new JPanel();
    jpanel.setLayout(null);
    jpanel.setBackground(Color.cyan);
    frame.add(jpanel);
    JLabel  jab=new JLabel("是否确定存款");
    jab.setFont(new Font("Dialog",1,20));
    jab.setBounds(430,200,1000,20);
    jpanel.add(jab);
    JLabel  jab2=new JLabel("存款金额：");
    jab2.setFont(new Font("Dialog",1,18));
    jab2.setBounds(300,300,200,30);
    jpanel.add(jab2);
    JTextField jtf=new JTextField();
    jtf.setBounds(450,300,200,30);
    jpanel.add(jtf);
    //确认存款按钮 
    JButton sureAccounts=new JButton("确认存款");
    sureAccounts.setBounds(200,500,100,30);
    sureAccounts.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 			String accouts=jtf.getText();
 			String[] string=null;
 			try {
 				new ATMClient("4",username, password,accouts,"存款").start();
				 string=Dataparsing.dataparsing(); 
				 string[0]=string[0].trim();
					string[1]=string[1].trim();
					string[2]=string[2].trim();
					string[3]=string[3].trim();
					string[4]=string[4].trim();
				if(string[4].equals("存款成功")) {
					JOptionPane.showMessageDialog(null, "您存入金额为"+string[3], "提示",JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
			     Transaction.transactionframe(username,password);
				}
				else {
					JOptionPane.showMessageDialog(null, "您输入有误，请重新输入金额", "提示",JOptionPane.PLAIN_MESSAGE);
				     Transaction.transactionframe(username,password);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}});
    jpanel.add(sureAccounts);
    //取消按钮
JButton cancel=new JButton("取消");
cancel.setBounds(700,500,100,30);
  cancel.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 			frame.dispose();
 			Transaction.transactionframe(username,password);
 		}});
  jpanel.add(cancel);
  JframeUtil.frameProperty(frame,1000,800);
}

}
