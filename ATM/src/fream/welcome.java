package fream;
/*
 * ��ӭҳ��
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
			//������ӭ����
			JFrame jframe=new JFrame();
			JPanel jpanel=new JPanel();
			jpanel.setLayout(null);
			jpanel.setBackground(Color.cyan);
			jframe.add(jpanel);
			
			JLabel jlabel= new JLabel("��ӭ������������");
			jlabel.setBounds(400,200,1000,30);
			jlabel.setFont(new Font("����", 20, 30));
			jlabel.setBackground(Color.blue);
			jpanel.add(jlabel);
			
			//����ע�ᰴť
			JButton registered=new JButton("ע��");
			registered.setBounds(300,400,100,30);
			registered.addActionListener(new ActionListener () {
				
				public void actionPerformed(ActionEvent arg0) {
					jframe.dispose(); 
					fream.registered.registeredframe();
				}
			});
			jpanel.add(registered);
			//������¼��ť
			JButton login=new JButton("��¼");
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
	
	

