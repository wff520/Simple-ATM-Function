package fream;
//修改密码功能
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class changepasswordFrame {
	public static void changepasswordframe(String username, String password) {
		// 创建登录窗体,并初始化
		JFrame frame = new JFrame("富风银行");
		// 创建 面板,设置面板布局为null
		JPanel jpanel = new JPanel();
		jpanel.setLayout(null);
		jpanel.setBackground(Color.cyan);
		frame.add(jpanel);
		// 创建标签及输入框
		JLabel jab1 = new JLabel("请输入您的新密码:");
		jab1.setBounds(350, 200, 1000, 20);
		jab1.setFont(new Font("Dialog", 1, 19));
		jpanel.add(jab1);
		JPasswordField jtf1 = new JPasswordField();
		jtf1.setBounds(350, 250, 300, 30);
		jpanel.add(jtf1);
		JLabel jab2 = new JLabel("请再次输入您的密码");
		jab2.setBounds(350, 300, 1000, 20);
		jab2.setFont(new Font("Dialog", 1, 19));
		jpanel.add(jab2);
		JPasswordField jtf2 = new JPasswordField();
		jtf2.setBounds(350, 350, 300, 30);
		jpanel.add(jtf2);
		// 添加确认按钮及其监听，确认两次输入的密码是否一致
		JButton sure = new JButton("确认");
		sure.setBounds(200, 500, 100, 30);
			sure.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				//在确定下才能监听到输入框最后确定的数据
					String pw1 =String.valueOf(jtf1.getPassword());
					String pw2 = String.valueOf(jtf2.getPassword());
					//如果两次密码一致，则发送修改密码给服务端
					if (pw1.equals(pw2)) {
						String[] string=null;
						try {
							new ATMClient("7", username, password, pw1, "修改密码").start();
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
						JOptionPane jop = new JOptionPane();
						if (string[4].equals("2")) {
							jop.showMessageDialog(null, "密码修改成功,重新登录", "提示", JOptionPane.PLAIN_MESSAGE);
							frame.dispose(); 
							welcome.welcomeframe();
						}
				}
				//如若不一致，则直接返回信息给客户
				else {
					JOptionPane.showMessageDialog(null, "两次密码输入不一致，请重新输入", "提示", JOptionPane.PLAIN_MESSAGE);
				}}});
			jpanel.add(sure);
		// 添加取消按钮
		JButton cancel = new JButton("取消");
		cancel.setBounds(700, 500, 100, 30);
		cancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				frame.dispose(); 
				Transaction.transactionframe(username, password);
			}
		});
		jpanel.add(cancel);
		JframeUtil.frameProperty(frame, 1000, 800);
	}
}