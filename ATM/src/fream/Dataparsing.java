package fream;
/*
 * 客户接收端，解析数据，并返回数据数组
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Dataparsing {
 public static String[]  dataparsing() throws Exception {
	 DatagramSocket  dtagramsocket=new DatagramSocket(10080);
	 byte[] rev = new byte[1024];
	 DatagramPacket datagramPacket = new DatagramPacket(rev, rev.length,InetAddress.getLocalHost(),10080);
	 dtagramsocket.receive(datagramPacket);
	  String data=new String(rev,0,rev.length);
	  dtagramsocket.close();
	  System.out.println("數據接收neng 成功");
	  String[]string=data.split(" ");
	 return  string;
 }
}
