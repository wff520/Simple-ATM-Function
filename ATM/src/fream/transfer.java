package fream;
/*
 * ת��ҳ��
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
	//��������,����ʼ�������õ�������־�Ϊ�޲�������
    JFrame frame=new JFrame("��������");
   //���� ���,������岼��Ϊnull
    JPanel  jpanel=new JPanel();
    jpanel.setLayout(null);
    jpanel.setBackground(Color.cyan);
    frame.add(jpanel);
    JLabel  jab1=new JLabel("��������ת����˻���");
    jab1.setFont(new Font("Dialog",1,19))	;
    jab1.setBounds(200,100,200,20);
    jpanel.add( jab1);
    JTextField jtf1=new JTextField();
    
    jtf1.setBounds(200,200,300,35);
    jpanel.add( jtf1);
    JLabel  jab2=new JLabel("ת�˽�");
    jab2.setFont(new Font("Dialog",1,19))	;
    jab2.setBounds(200,300,100,20);
    jpanel.add( jab2);
    JTextField jtf2=new JTextField();
    jtf2.setBounds(200,400,300,35);
    jpanel.add( jtf2);
   
    //ȷ�ϴ�ť 
    JButton sure=new JButton("ȷ��");
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
				
				if(string[4].equals("ת�˳ɹ�")) {
					JOptionPane.showMessageDialog(null, "��ת���˻�Ϊ��Ϊ"+name+"ת����Ϊ:"+accouts, "��ʾ",JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
					Transaction.transactionframe(username,password);
				}
				else if(string[4].equals("��������")){
					JOptionPane.showMessageDialog(null, "��������", "��ʾ",JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
					transferFrame( username,password);
				}
				else {
					JOptionPane.showMessageDialog(null, "û�и��˻�������������", "��ʾ",JOptionPane.PLAIN_MESSAGE);
					frame.dispose();
					transferFrame( username,password);
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}});
    jpanel.add(sure);
    JButton cancel=new JButton("ȡ��");
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