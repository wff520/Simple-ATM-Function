package fream;
/*
 * 取款页面，各种取款选项
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
	//创建登录窗体,并初始化
    JFrame frame=new JFrame("富风银行");
   //创建 面板,设置面板布局为null
    JPanel  jpanel=new JPanel();
    jpanel.setLayout(null);
    jpanel.setBackground(Color.cyan);
    frame.add(jpanel);
    JLabel  jab=new JLabel("请输入您要提取的金额:(单次最高面额不超过5000)");
    jab.setBounds(100,100,500,20);
    jab.setFont(new Font("Dialog",1,19));
    jpanel.add(jab);
    JButton accouts1=new JButton("100元");
    accouts1.setBounds(150, 150, 100, 35);
    accouts1.addActionListener(new ActionListener () {
 		
 		public void actionPerformed(ActionEvent arg0) {
 			String[] string=null;
 		
 			
 				try {
 					new ATMClient("6",username,password,"100","取款100元" ).start();
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
				if(string[4].equals("取款成功")) {
			     //jop.showMessageDialog(null, "您存入金额为"+string[3]+"您的余额为:"+string[3], "提示",JOptionPane.PLAIN_MESSAGE);
			     int num = jop.showConfirmDialog(null, "您存入金额为"+string[3]+"您的余额为:"+string[3]+"\n是否继续", "提示",JOptionPane.PLAIN_MESSAGE);
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
					jop.showMessageDialog(null, "您余额不足", "提示",JOptionPane.YES_NO_OPTION );
					frame.dispose();
				     Transaction.transactionframe(username,password);
				}
 		}});
    jpanel.add(accouts1);
JButton accouts2=new JButton("200元");
accouts2.setBounds(650, 150, 100, 35);
accouts2.addActionListener(new ActionListener () {
		public void actionPerformed(ActionEvent arg0) {
			String[] string=null;
 				try {
 					new ATMClient("6",username,password,"200","取款200元"  ).start();
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
			if(string[4].equals("取款成功")) {
		     //jop.showMessageDialog(null, "您存入金额为"+string[3]+"您的余额为:"+string[3], "提示",JOptionPane.PLAIN_MESSAGE);
		     int num = jop.showConfirmDialog(null, "您存入金额为"+string[3]+"您的余额为:"+string[3]+"\n是否继续", "提示",JOptionPane.PLAIN_MESSAGE);
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
				jop.showMessageDialog(null, "您余额不足", "提示",JOptionPane.YES_NO_OPTION );
				frame.dispose();
			     Transaction.transactionframe(username,password);
			}
		} 
		});
    jpanel.add(accouts2);
    JButton accouts3=new JButton("300元");
    accouts3.setBounds(150, 250, 100, 35);
    accouts3.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 			String[] string=null;
 				try {
 					new ATMClient("6",username,password,"300","取款300元"  ).start();
 					System.out.println("数据是能够发送的");
 					 string=Dataparsing.dataparsing(); 
 					System.out.println("数据是能够接收的");
 					
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
				if(string[4].equals("取款成功")) {
			     //jop.showMessageDialog(null, "您存入金额为"+string[3]+"您的余额为:"+string[3], "提示",JOptionPane.PLAIN_MESSAGE);
			     int num = jop.showConfirmDialog(null, "您取款金额为："+"300元;"+"您的余额为:"+string[3]+"\n是否继续", "提示",JOptionPane.YES_NO_OPTION );
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
					jop.showMessageDialog(null, "您余额不足", "提示",JOptionPane.YES_NO_OPTION   );
					frame.dispose();
				    Transaction.transactionframe(username,password);
				}
 		}});
    jpanel.add(accouts3);
    JButton accouts4=new JButton("400元");
    accouts4.setBounds(650, 250, 100, 35);
    accouts4.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 			String[] string=null;
 			try {
 				new ATMClient("6",username,password,"400","取款400元"  ).start();
				 string=Dataparsing.dataparsing(); 
				 string[0]=string[0].trim();
					string[1]=string[1].trim();
					string[2]=string[2].trim();
					string[3]=string[3].trim();
					string[4]=string[4].trim();
				JOptionPane jop=new JOptionPane();
				if(string[4].equals("取款成功")) {
			     //jop.showMessageDialog(null, "您存入金额为"+string[3]+"您的余额为:"+string[3], "提示",JOptionPane.PLAIN_MESSAGE);
			     int num = jop.showConfirmDialog(null, "您取款金额为："+"您的余额为:"+string[3]+"\n是否继续", "提示",JOptionPane.YES_NO_OPTION );
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
					jop.showMessageDialog(null, "您余额不足", "提示",JOptionPane.YES_NO_OPTION );
					frame.dispose();
				     Transaction.transactionframe(username,password);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}});
jpanel.add(accouts4);
    JButton accouts5=new JButton("500元");
    accouts5.setBounds(150, 350, 100, 35);
accouts5.addActionListener(new ActionListener () {
 		
 		public void actionPerformed(ActionEvent arg0) {
 			String[] string=null;
 			try {
 				new ATMClient("6",username,password,"500","取款500元" ).start();
				 string=Dataparsing.dataparsing(); 
				 string[0]=string[0].trim();
					string[1]=string[1].trim();
					string[2]=string[2].trim();
					string[3]=string[3].trim();
					string[4]=string[4].trim();
				JOptionPane jop=new JOptionPane();
				if(string[4].equals("取款成功")) {
			     //jop.showMessageDialog(null, "您存入金额为"+string[3]+"您的余额为:"+string[3], "提示",JOptionPane.PLAIN_MESSAGE);
			     int num = jop.showConfirmDialog(null, "您取款金额为：500元"+"您的余额为:"+string[3]+"\n是否继续", "提示",JOptionPane.YES_NO_OPTION);
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
					jop.showMessageDialog(null, "您余额不足", "提示",JOptionPane.YES_NO_OPTION );
					frame.dispose();
				     Transaction.transactionframe(username,password);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
 		}});
jpanel.add(accouts5);
    JButton otheraccouts=new JButton("其他面额");
    otheraccouts.setBounds(650, 350, 100, 35);
    otheraccouts.addActionListener(new ActionListener () {
 		public void actionPerformed(ActionEvent arg0) {
 				JOptionPane jop=new JOptionPane();
 				 String money=jop.showInputDialog(null,"请输入你要取款金：","提示",JOptionPane.OK_CANCEL_OPTION );
 				String[] string=null;
 	 			try {
 	 				new ATMClient("6",username,password,money,"取款其它").start();
 					 string=Dataparsing.dataparsing(); 
 					 string[0]=string[0].trim();
 						string[1]=string[1].trim();
 						string[2]=string[2].trim();
 						string[3]=string[3].trim();
 						string[4]=string[4].trim();
				if(string[4].equals("取款成功")) {
			     //jop.showMessageDialog(null, "您存入金额为"+string[3]+"您的余额为:"+string[3], "提示",JOptionPane.PLAIN_MESSAGE);
			     int num = jop.showConfirmDialog(null, "您转账金额为："+money+"元"+"您的余额:"+string[3]+"\n是否继续", "提示",JOptionPane.YES_NO_OPTION);
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
					jop.showMessageDialog(null, "您余额不足", "提示",JOptionPane.YES_NO_OPTION );
					frame.dispose();
				     Transaction.transactionframe(username,password);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}});
    jpanel.add(otheraccouts);
    JButton back=new JButton("返回"); 
    back.setBounds(150, 450, 100, 35);
    back.addActionListener(new ActionListener () {
   		
   		public void actionPerformed(ActionEvent arg0) {
   			frame.dispose();
   			Transaction.transactionframe(username,password);
   		}});
    jpanel.add(back);
	    JButton cancel=new JButton("取消");
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

