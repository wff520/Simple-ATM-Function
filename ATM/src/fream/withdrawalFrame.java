package fream;
/*
 * ȡ��ҳ�棬����ȡ��ѡ��
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

public class withdrawalFrame {
public static void  withdrawalframe(String username,String password) {
	//������¼����,����ʼ��
    JFrame frame=new JFrame("��������");
   //���� ���,������岼��Ϊnull
    JPanel  jpanel=new JPanel();
    jpanel.setLayout(null);
    jpanel.setBackground(Color.cyan);
    frame.add(jpanel);
    JLabel  jab=new JLabel("��������Ҫ��ȡ�Ľ��:(�������������5000)");
    jab.setBounds(100,100,500,20);
    jab.setFont(new Font("Dialog",1,19));
    jpanel.add(jab);
    JButton accouts1=new JButton("100Ԫ");
    accouts1.setBounds(150, 150, 100, 35);
    accouts1.addActionListener(new ActionListener () {
 		
 		public void actionPerformed(ActionEvent arg0) {
 			String[] string=null;
 		
 			
 				try {
 					new ATMClient("6",username,password,"100","ȡ��100Ԫ" ).start();
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
				JOptionPane jop=new JOptionPane();
				if(string[4].equals("ȡ��ɹ�")) {
			     //jop.showMessageDialog(null, "��������Ϊ"+string[3]+"�������Ϊ:"+string[3], "��ʾ",JOptionPane.PLAIN_MESSAGE);
			     int num = jop.showConfirmDialog(null, "��������Ϊ"+string[3]+"�������Ϊ:"+string[3]+"\n�Ƿ����", "��ʾ",JOptionPane.PLAIN_MESSAGE);
			     if(num==0) {
			    	 frame.dispose();
			    	 withdrawalframe( username, password);
			     }
			     if(num==1) {
			    	 frame.dispose();
			    	 Transaction.transactionframe(username,password);
			     }
				}
				else {
					jop.showMessageDialog(null, "������", "��ʾ",JOptionPane.YES_NO_OPTION );
					frame.dispose();
				     Transaction.transactionframe(username,password);
				}
 		}});
    jpanel.add(accouts1);
JButton accouts2=new JButton("200Ԫ");
accouts2.setBounds(650, 150, 100, 35);
accouts2.addActionListener(new ActionListener () {
		public void actionPerformed(ActionEvent arg0) {
			String[] string=null;
 				try {
 					new ATMClient("6",username,password,"200","ȡ��200Ԫ"  ).start();
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
			JOptionPane jop=new JOptionPane();
			if(string[4].equals("ȡ��ɹ�")) {
		     //jop.showMessageDialog(null, "��������Ϊ"+string[3]+"�������Ϊ:"+string[3], "��ʾ",JOptionPane.PLAIN_MESSAGE);
		     int num = jop.showConfirmDialog(null, "��������Ϊ"+string[3]+"�������Ϊ:"+string[3]+"\n�Ƿ����", "��ʾ",JOptionPane.PLAIN_MESSAGE);
		     if(num==0) {
		    	 frame.dispose();
		    	 withdrawalframe( username, password);
		     }
		     if(num==1) {
		    	 frame.dispose();
		    	 Transaction.transactionframe(username,password);
		     }
		     
			}
			else {
				jop.showMessageDialog(null, "������", "��ʾ",JOptionPane.YES_NO_OPTION );
				frame.dispose();
			     Transaction.transactionframe(username,password);
			}
		} 
		});
    jpanel.add(accouts2);
    JButton accouts3=new JButton("300Ԫ");
    accouts3.setBounds(150, 250, 100, 35);
    accouts3.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 			String[] string=null;
 				try {
 					new ATMClient("6",username,password,"300","ȡ��300Ԫ"  ).start();
 					System.out.println("�������ܹ����͵�");
 					 string=Dataparsing.dataparsing(); 
 					System.out.println("�������ܹ����յ�");
 					
 					 string[0]=string[0].trim();
 						string[1]=string[1].trim();
 						string[2]=string[2].trim();
 						string[3]=string[3].trim();
 						string[4]=string[4].trim();
 						System.out.println("{"+string[0]+"}"+"{"+string[1]+"}"+"{"+string[2]+"}"+"{"+string[3]+"}"+"{"+string[4]+"}");
 				} catch (Exception e) {
 					// TODO Auto-generated catch block
 					e.printStackTrace();
 				}
				JOptionPane jop=new JOptionPane();
				if(string[4].equals("ȡ��ɹ�")) {
			     //jop.showMessageDialog(null, "��������Ϊ"+string[3]+"�������Ϊ:"+string[3], "��ʾ",JOptionPane.PLAIN_MESSAGE);
			     int num = jop.showConfirmDialog(null, "��ȡ����Ϊ��"+"300Ԫ;"+"�������Ϊ:"+string[3]+"\n�Ƿ����", "��ʾ",JOptionPane.YES_NO_OPTION );
			     if(num==0) {
			    	 frame.dispose();
			    	 Transaction.transactionframe(username,password);
			     }
			     if(num==1) {
			    	 frame.dispose();
			    	 withdrawalframe( username, password);
			     }
				}
				else {
					jop.showMessageDialog(null, "������", "��ʾ",JOptionPane.YES_NO_OPTION   );
					frame.dispose();
				    Transaction.transactionframe(username,password);
				}
 		}});
    jpanel.add(accouts3);
    JButton accouts4=new JButton("400Ԫ");
    accouts4.setBounds(650, 250, 100, 35);
    accouts4.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 			String[] string=null;
 			try {
 				new ATMClient("6",username,password,"400","ȡ��400Ԫ"  ).start();
				 string=Dataparsing.dataparsing(); 
				 string[0]=string[0].trim();
					string[1]=string[1].trim();
					string[2]=string[2].trim();
					string[3]=string[3].trim();
					string[4]=string[4].trim();
				JOptionPane jop=new JOptionPane();
				if(string[4].equals("ȡ��ɹ�")) {
			     //jop.showMessageDialog(null, "��������Ϊ"+string[3]+"�������Ϊ:"+string[3], "��ʾ",JOptionPane.PLAIN_MESSAGE);
			     int num = jop.showConfirmDialog(null, "��ȡ����Ϊ��"+"�������Ϊ:"+string[3]+"\n�Ƿ����", "��ʾ",JOptionPane.YES_NO_OPTION );
			     if(num==0) {
			    	 frame.dispose();
			    	 withdrawalframe( username, password);
			     }
			     if(num==1) {
			    	 frame.dispose();
			    	 Transaction.transactionframe(username,password);
			     }
				}
				else {
					jop.showMessageDialog(null, "������", "��ʾ",JOptionPane.YES_NO_OPTION );
					frame.dispose();
				     Transaction.transactionframe(username,password);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}});
jpanel.add(accouts4);
    JButton accouts5=new JButton("500Ԫ");
    accouts5.setBounds(150, 350, 100, 35);
accouts5.addActionListener(new ActionListener () {
 		
 		public void actionPerformed(ActionEvent arg0) {
 			String[] string=null;
 			try {
 				new ATMClient("6",username,password,"500","ȡ��500Ԫ" ).start();
				 string=Dataparsing.dataparsing(); 
				 string[0]=string[0].trim();
					string[1]=string[1].trim();
					string[2]=string[2].trim();
					string[3]=string[3].trim();
					string[4]=string[4].trim();
				JOptionPane jop=new JOptionPane();
				if(string[4].equals("ȡ��ɹ�")) {
			     //jop.showMessageDialog(null, "��������Ϊ"+string[3]+"�������Ϊ:"+string[3], "��ʾ",JOptionPane.PLAIN_MESSAGE);
			     int num = jop.showConfirmDialog(null, "��ȡ����Ϊ��500Ԫ"+"�������Ϊ:"+string[3]+"\n�Ƿ����", "��ʾ",JOptionPane.YES_NO_OPTION);
			     if(num==0) {
			    	 frame.dispose();
			    	 withdrawalframe( username, password);
			     }
			     if(num==1) {
			    	 frame.dispose();
			    	 Transaction.transactionframe(username,password);
			     }
				}
				else {
					jop.showMessageDialog(null, "������", "��ʾ",JOptionPane.YES_NO_OPTION );
					frame.dispose();
				     Transaction.transactionframe(username,password);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
 		}});
jpanel.add(accouts5);
    JButton otheraccouts=new JButton("�������");
    otheraccouts.setBounds(650, 350, 100, 35);
    otheraccouts.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 				JOptionPane jop=new JOptionPane();
 				 String money=jop.showInputDialog(null,"��������Ҫȡ���","��ʾ",JOptionPane.OK_CANCEL_OPTION );
 				String[] string=null;
 	 			try {
 	 				new ATMClient("6",username,password,money,"ȡ������").start();
 					 string=Dataparsing.dataparsing(); 
 					 string[0]=string[0].trim();
 						string[1]=string[1].trim();
 						string[2]=string[2].trim();
 						string[3]=string[3].trim();
 						string[4]=string[4].trim();
				if(string[4].equals("ȡ��ɹ�")) {
			     //jop.showMessageDialog(null, "��������Ϊ"+string[3]+"�������Ϊ:"+string[3], "��ʾ",JOptionPane.PLAIN_MESSAGE);
			     int num = jop.showConfirmDialog(null, "��ת�˽��Ϊ��"+money+"Ԫ"+"�������:"+string[3]+"\n�Ƿ����", "��ʾ",JOptionPane.YES_NO_OPTION);
			     if(num==0) {
			    	 frame.dispose();
			    	 withdrawalframe( username, password);
			     }
			     if(num==1) {
			    	 frame.dispose();
			    	 Transaction.transactionframe(username,password);
			     }
				}
				else {
					jop.showMessageDialog(null, "������", "��ʾ",JOptionPane.YES_NO_OPTION );
					frame.dispose();
				     Transaction.transactionframe(username,password);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}});
    jpanel.add(otheraccouts);
    JButton back=new JButton("����"); 
    back.setBounds(150, 450, 100, 35);
    back.addActionListener(new ActionListener () {
   		
   		public void actionPerformed(ActionEvent arg0) {
   			frame.dispose();
   			Transaction.transactionframe(username,password);
   		}});
    jpanel.add(back);
	    JButton cancel=new JButton("ȡ��");
	    cancel.setBounds(650, 450, 100, 35);
	    cancel.addActionListener(new ActionListener () {
	   		
	   		public void actionPerformed(ActionEvent arg0) {
	   			frame.dispose();
	   			withdrawalframe(username,password);
	   		}});
	    jpanel.add(cancel);
  JframeUtil.frameProperty(frame,1000,800);
}

}

