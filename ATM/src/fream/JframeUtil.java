package fream;
/*
 * ��ʼ������,���ô����λ�á��ر��Լ������С
 */
import java.awt.Dimension;
import java.awt.Toolkit ;


import javax.swing.JFrame;

public class JframeUtil {

public static void frameProperty(JFrame frame,int width,int heigth) {
	//��ȡһ����ϵͳ��ع��������
	Toolkit toolkit = Toolkit.getDefaultToolkit(); 
	Dimension d=toolkit .getScreenSize();
	 int x=(int)d.width;
	 int y=(int)d.height;
	 frame.setBounds((x-width)/2, (y-heigth)/2,width,heigth);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
