package fream;
/*
 * 初始化窗体,设置窗体的位置、关闭以及窗体大小
 */
import java.awt.Dimension;
import java.awt.Toolkit ;


import javax.swing.JFrame;

public class JframeUtil {

public static void frameProperty(JFrame frame,int width,int heigth) {
	//获取一个与系统相关工具类对象
	Toolkit toolkit = Toolkit.getDefaultToolkit(); 
	Dimension d=toolkit .getScreenSize();
	 int x=(int)d.width;
	 int y=(int)d.height;
	 frame.setBounds((x-width)/2, (y-heigth)/2,width,heigth);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
