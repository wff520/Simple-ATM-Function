package fream;
/*
 * 注册页面
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
	//创建窗口及面板
	JFrame jframe=new JFrame();
	JPanel jpanel=new JPanel();
	jpanel.setBackground(Color.cyan);
	jpanel.setLayout(null);
	jframe.add(jpanel);
	//注册页面
	JLabel username=new JLabel("请输入您的卡号:");
    username.setBounds(300,200,200,20);
    username.setFont(new Font("Dialog",1,17));
    //用户名的输入框
   // String name="www";
   JTextField jtf=new JTextField();
    // jtf.setText("12121");
     jtf.setBounds(450,200,220,30);
     jpanel.add(username);
      jpanel.add(jtf);
 //密码标签及输入框
   JLabel password=new JLabel("请输入您的密码:");
   password.setFont(new Font("Dialog",1,17));
   password.setBounds(300,300,200,20);
   JPasswordField jpf=new JPasswordField(15);
   jpf.setBounds(450,300,220,30);
   jpanel.add(password);
   jpanel.add(jpf);
   //读取卡号及密码内容，并发送至服务端确认。
	//创建注册按钮
	JButton registered=new JButton("确认注册");
	registered.setBounds(250,500,100,30);
	registered.addActionListener(new ActionListener () {
		
		public void actionPerformed(ActionEvent arg0) {
			try {
				 String name=jtf.getText();
				 String pw=String.valueOf(jpf.getPassword());
				 System.out.println("{"+name+pw+"}");
				new ATMClient("1",name,pw,"0","1").start();
				String[]string=Dataparsing.dataparsing(); 
				System.out.println("数据接收成功");
				System.out.println(name+pw);
				System.out.println(string[4]);
			if(Integer.parseInt(string[4].trim())==1) {
	        //JOptionPane jop=new JOptionPane();
			JOptionPane.showMessageDialog(null, "注册成功,请登录.", "消息",JOptionPane.PLAIN_MESSAGE);  
			jframe.dispose(); 
			loginframe.login();
					}
					else if(string[4].trim().equals("2")){
			JOptionPane jop=new JOptionPane();
		     jop.showMessageDialog(null, "您注册的账号已经存在", "消息",JOptionPane.PLAIN_MESSAGE); 
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
	//使用返回键回到欢迎页面
	JButton back=new JButton("返回");
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
