package fream;
/*
 * ע��ҳ��
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class registered {
	
public static void registeredframe() {
	//�������ڼ����
	JFrame jframe=new JFrame();
	JPanel jpanel=new JPanel();
	jpanel.setBackground(Color.cyan);
	jpanel.setLayout(null);
	jframe.add(jpanel);
	//ע��ҳ��
	JLabel username=new JLabel("���������Ŀ���:");
    username.setBounds(300,200,200,20);
    username.setFont(new Font("Dialog",1,17));
    //�û����������
   // String name="www";
   JTextField jtf=new JTextField();
    // jtf.setText("12121");
     jtf.setBounds(450,200,220,30);
     jpanel.add(username);
      jpanel.add(jtf);
 //�����ǩ�������
   JLabel password=new JLabel("��������������:");
   password.setFont(new Font("Dialog",1,17));
   password.setBounds(300,300,200,20);
   JPasswordField jpf=new JPasswordField(15);
   jpf.setBounds(450,300,220,30);
   jpanel.add(password);
   jpanel.add(jpf);
   //��ȡ���ż��������ݣ��������������ȷ�ϡ�
	//����ע�ᰴť
	JButton registered=new JButton("ȷ��ע��");
	registered.setBounds(250,500,100,30);
	registered.addActionListener(new ActionListener () {
		
		public void actionPerformed(ActionEvent arg0) {
			try {
				 String name=jtf.getText();
				 String pw=String.valueOf(jpf.getPassword());
				 System.out.println("{"+name+pw+"}");
				new ATMClient("1",name,pw,"0","1").start();
				String[]string=Dataparsing.dataparsing(); 
				System.out.println("���ݽ��ճɹ�");
				System.out.println(name+pw);
				System.out.println(string[4]);
			if(Integer.parseInt(string[4].trim())==1) {
	        //JOptionPane jop=new JOptionPane();
			JOptionPane.showMessageDialog(null, "ע��ɹ�,���¼.", "��Ϣ",JOptionPane.PLAIN_MESSAGE);  
			jframe.dispose(); 
			loginframe.login();
					}
					else if(string[4].trim().equals("2")){
			JOptionPane jop=new JOptionPane();
		     jop.showMessageDialog(null, "��ע����˺��Ѿ�����", "��Ϣ",JOptionPane.PLAIN_MESSAGE); 
		     jframe.dispose(); 
		     welcome.welcomeframe();
						}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
		}
});
	jpanel.add(registered);
	//ʹ�÷��ؼ��ص���ӭҳ��
	JButton back=new JButton("����");
	 back.setBounds(700,500,100,30);
   back.addActionListener(new ActionListener () {
		
		public void actionPerformed(ActionEvent arg0) {
			jframe.dispose(); 
			welcome.welcomeframe();
		}});
    jpanel.add(back);
    JframeUtil.frameProperty(jframe,1000,800);
	
}

}
