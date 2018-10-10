package fream;
/*
 * 欢迎页面
 */
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcome {
	
		public  static void welcomeframe() {
			//创建欢迎窗体
			JFrame jframe=new JFrame();
			JPanel jpanel=new JPanel();
			jpanel.setLayout(null);
			jpanel.setBackground(Color.cyan);
			jframe.add(jpanel);
			
			JLabel jlabel= new JLabel("欢迎来到富风银行");
			jlabel.setBounds(400,200,1000,30);
			jlabel.setFont(new Font("隶书", 20, 30));
			jlabel.setBackground(Color.blue);
			jpanel.add(jlabel);
			
			//创建注册按钮
			JButton registered=new JButton("注册");
			registered.setBounds(300,400,100,30);
			registered.addActionListener(new ActionListener () {
				
				public void actionPerformed(ActionEvent arg0) {
					jframe.dispose(); 
					fream.registered.registeredframe();
				}
			});
			jpanel.add(registered);
			//创建登录按钮
			JButton login=new JButton("登录");
			login.setBounds(700,400,100,30);
               login.addActionListener(new ActionListener () {
				public void actionPerformed(ActionEvent arg0) {
					jframe.dispose();
					loginframe.login();
				}
			
			});
               jpanel.add(login);
               JframeUtil.frameProperty(jframe,1000,800);
		}
		public static void main(String[] args) {
			welcomeframe();
		}
	}
	
	

