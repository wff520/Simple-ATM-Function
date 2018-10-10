package fream;
/*
 * ���Ͷˣ����ݰ���ʽΪ��ѡ�������͡��û��������롢�����ݡ�
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javafx.scene.chart.PieChart.Data;

public class ATMClient  extends Thread {
	String choose;
	String username;
	String password;
	String accounts;
	String conenton;
	public ATMClient(String choose,String username,String password,String accounts,String conenton) {
		this.choose=choose;
		this.username=username;
	     this.password=password;
		this.accounts=accounts;
		this.conenton=conenton;
	}
	public void run() {
		DatagramSocket dgs=null;
		try {
			dgs=new DatagramSocket();
			String string=choose+" "+username+" "+password+" "+accounts+" "+conenton;
			DatagramPacket dgp=new DatagramPacket(string.getBytes(), string.getBytes().length,InetAddress.getLocalHost(),9080);
			dgs.send(dgp);
			
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}