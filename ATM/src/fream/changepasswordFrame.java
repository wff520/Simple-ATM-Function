package fream;
//�޸����빦��
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
		// ������¼����,����ʼ��
		JFrame frame = new JFrame("��������");
		// ���� ���,������岼��Ϊnull
		JPanel jpanel = new JPanel();
		jpanel.setLayout(null);
		jpanel.setBackground(Color.cyan);
		frame.add(jpanel);
		// ������ǩ�������
		JLabel jab1 = new JLabel("����������������:");
		jab1.setBounds(350, 200, 1000, 20);
		jab1.setFont(new Font("Dialog", 1, 19));
		jpanel.add(jab1);
		JPasswordField jtf1 = new JPasswordField();
		jtf1.setBounds(350, 250, 300, 30);
		jpanel.add(jtf1);
		JLabel jab2 = new JLabel("���ٴ�������������");
		jab2.setBounds(350, 300, 1000, 20);
		jab2.setFont(new Font("Dialog", 1, 19));
		jpanel.add(jab2);
		JPasswordField jtf2 = new JPasswordField();
		jtf2.setBounds(350, 350, 300, 30);
		jpanel.add(jtf2);
		// ���ȷ�ϰ�ť���������ȷ����������������Ƿ�һ��
		JButton sure = new JButton("ȷ��");
		sure.setBounds(200, 500, 100, 30);
			sure.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				//��ȷ���²��ܼ�������������ȷ��������
					String pw1 =String.valueOf(jtf1.getPassword());
					String pw2 = String.valueOf(jtf2.getPassword());
					//�����������һ�£������޸�����������
					if (pw1.equals(pw2)) {
						String[] string=null;
						try {
							new ATMClient("7", username, password, pw1, "�޸�����").start();
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
							jop.showMessageDialog(null, "�����޸ĳɹ�,���µ�¼", "��ʾ", JOptionPane.PLAIN_MESSAGE);
							frame.dispose(); 
							welcome.welcomeframe();
						}
				}
				//������һ�£���ֱ�ӷ�����Ϣ���ͻ�
				else {
					JOptionPane.showMessageDialog(null, "�����������벻һ�£�����������", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				}}});
			jpanel.add(sure);
		// ���ȡ����ť
		JButton cancel = new JButton("ȡ��");
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