package fream;
//����ʵ��
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
	//������¼����,����ʼ��
    JFrame frame=new JFrame("��������");
   //���� ���,������岼��Ϊnull
    JPanel  jpanel=new JPanel();
    jpanel.setLayout(null);
    jpanel.setBackground(Color.cyan);
    frame.add(jpanel);
    JLabel  jab=new JLabel("�Ƿ�ȷ�����");
    jab.setFont(new Font("Dialog",1,20));
    jab.setBounds(430,200,1000,20);
    jpanel.add(jab);
    JLabel  jab2=new JLabel("����");
    jab2.setFont(new Font("Dialog",1,18));
    jab2.setBounds(300,300,200,30);
    jpanel.add(jab2);
    JTextField jtf=new JTextField();
    jtf.setBounds(450,300,200,30);
    jpanel.add(jtf);
    //ȷ�ϴ�ť 
    JButton sureAccounts=new JButton("ȷ�ϴ��");
    sureAccounts.setBounds(200,500,100,30);
    sureAccounts.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 			String accouts=jtf.getText();
 			String[] string=null;
 			try {
 				new ATMClient("4",username, password,accouts,"���").start();
				 string=Dataparsing.dataparsing(); 
				 string[0]=string[0].trim();
					string[1]=string[1].trim();
					string[2]=string[2].trim();
					string[3]=string[3].trim();
					string[4]=string[4].trim();
				if(string[4].equals("���ɹ�")) {
					JOptionPane.showMessageDialog(null, "��������Ϊ"+string[3], "��ʾ",JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
			     Transaction.transactionframe(username,password);
				}
				else {
					JOptionPane.showMessageDialog(null, "����������������������", "��ʾ",JOptionPane.PLAIN_MESSAGE);
				     Transaction.transactionframe(username,password);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}});
    jpanel.add(sureAccounts);
    //ȡ����ť
JButton cancel=new JButton("ȡ��");
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
