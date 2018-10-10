package fream;
/*
 * 服务端：处理各种数据，接收数据以及将处理结果返回给用户端
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Properties;

public class ATMServer extends Thread {
	DatagramSocket socket;
	DatagramPacket datagramPacket;
	byte[] string2;
	 
	public ATMServer(DatagramSocket socket, DatagramPacket datagramPacket, byte[] string2) {
		super();
		this.socket = socket;
		this.datagramPacket = datagramPacket;
		this.string2 = string2;
	}

	public void run() {
		//读取配置文件
		File file1 = new File("user.properties");
		
		 File file2 = new File("name.properties");
		  try {
				if (!file1.exists()&&!file2.exists()) {
					file1.createNewFile();
					file2.createNewFile();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		Properties pps1 = new Properties();
		Properties pps2 = new Properties();
		try {
			pps1.load(new FileInputStream(file1));
			pps2.load(new FileInputStream(file2));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        //处理数据		
		String info = new String(string2);
		String[] string = info.split(" ");
		string[0]=string[0].trim();
		string[1]=string[1].trim();
		string[2]=string[2].trim();
		string[3]=string[3].trim();
		string[4]=string[4].trim();
		//验证数据是否一致
		System.out.println("{"+string[0]+"}"+"{"+string[1]+"}"+"{"+string[2]+"}"+"{"+string[3]+"}"+"{"+string[4]+"}");
		System.out.println("{"+Integer.parseInt(string[0])+"}");
		//注册页面
		if (Integer.parseInt(string[0]) == 1) {
			// 不存在该用户名,生成一个配置文件
			if (!pps1.containsKey(string[1])) {
					try {
						pps1.setProperty(string[1], string[2]);
						pps1.store(new FileWriter(file1), "账户信息");
						
						pps2.setProperty(string[1], "0");
						pps2.store(new FileWriter(file2), "账户余额");
						
						string[4] = "1";
						datasend(string[0], string[1], string[2], string[3], string[4]);}
				// 注册成功。返回1的内容
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
			 else {
				// 您注册的账号已经存在,返回2
				string[4] = "2";

				try {
					datasend(string[0], string[1], string[2], string[3], string[4]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		
		// 登录确认
		if (string[0].equals("2") ) {
			
			
			// 确认是否有该账户
			if (pps1.containsKey(string[1]) && pps2.containsKey(string[1])) {
				
				
				// 确认该账户与密码是否一致
				if (pps1.getProperty(string[1]).equals(string[2])) {
					
					
					// 用户账户密码正确，登录成功
					string[4] = "1";
					try {
						datasend(string[0], string[1], string[2], string[3], string[4]);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					// 用户密码错误，登录不成功
					string[4] = "2";
					try {
						datasend(string[0], string[1], string[2], string[3], string[4]);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				
			}
			
			else {
				// 没有该卡号存在
				string[4] = "3";
				try {
					datasend(string[0], string[1], string[2], string[3], string[4]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} 
		// 查询余额
		if (Integer.parseInt(string[0].trim()) == 3) {
			string[3] = pps2.getProperty(string[1]);
			try {
				datasend(string[0], string[1], string[2], string[3], string[4]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		// 存款
		if (Integer.parseInt(string[0]) == 4) {
			if (Integer.parseInt(string[3]) >= 0) {
				String acconts = Integer.parseInt(string[3]) + Integer.parseInt(pps2.getProperty(string[1])) + "";
				string[4] = "存款成功";
				//string[3] = pps2.getProperty(string[1]);
				string[3] = acconts.trim();
				try {
					pps2.setProperty(string[1], string[3]);
					pps2.store(new FileWriter(file2), "账户余额");
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					datasend(string[0], string[1], string[2], string[3], string[4].trim());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
			string[4] = "输入有误";
			try {
				datasend(string[0], string[1], string[2], string[3], string[4]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} }// 转账
		if (Integer.parseInt(string[0]) == 5) {
			// 如果账户正确
			if (pps2.containsKey(string[4])) {
				// 如果账户余额大于转账金额
				if (Integer.parseInt(pps2.getProperty(string[1])) >= Integer.parseInt(string[3])) {
					String other = Integer.parseInt(pps2.getProperty(string[4].trim())) + Integer.parseInt(string[3].trim()) + "";
					String myself = Integer.parseInt(pps2.getProperty(string[1])) - Integer.parseInt(string[3]) + "";
					pps2.setProperty(string[4], other);
					pps2.setProperty(string[1], myself);
					try {
						pps2.store(new FileWriter(file2), "账户余额");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					string[4] = "转账成功";
					try {
						datasend(string[0], string[1], string[2], string[3], string[4]);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				} // 小于转账金额，则不能转账
				else {
					string[4] = "您的余额不足";
					try {
						datasend(string[0], string[1], string[2], string[3], string[4]);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
			}
			}
		// 没有转账用户存在
		else {
			string[4] = "没有该账户，请重新输入";
			try {
				datasend(string[0], string[1], string[2], string[3], string[4]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}}
		// 取款
		if (Integer.parseInt(string[0]) == 6) {
			// 如果账户余额大于取款金额
			if (Integer.parseInt(pps2.getProperty(string[1])) >= Integer.parseInt(string[3])) {
				int name1=Integer.parseInt(pps2.getProperty(string[1]));
				int name2=Integer.parseInt(string[3]);
				String myself = String.valueOf(name1-name2);
				System.out.println(myself);
				pps2.setProperty(string[1], myself.trim());
					try {
						pps2.store(new FileWriter(file2), "账户余额");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				try {
					string[3] = myself;
				    string[4] = "取款成功";
					
					datasend(string[0], string[1], string[2], string[3], string[4]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// 账户余额小于转账金额，则不能转账
			else {
				string[4] = "您的余额不足";
				try {
					datasend(string[0], string[1], string[2], string[3], string[4]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} // 修改密码
		if (Integer.parseInt(string[0]) == 7) {
			pps1.setProperty(string[1], string[3]);
	
		    try {
				pps1.store(new FileWriter(file1), "账户信息");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			string[4] = "2";
			try {
				datasend(string[0], string[1], string[4], string[3], string[4]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
	public void datasend(String choose, String username, String password, String accounts, String conenton)throws Exception {
		//发送数据给客户端，并更换端口号
		byte[] bt = (choose + " " + username + " " + password + " " + accounts + " " + conenton).getBytes();
		DatagramPacket outgoingPacket = new DatagramPacket(bt, bt.length, InetAddress.getLocalHost(),10080);
		try {
			socket.send(outgoingPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws Exception {
		//循环接收数据
		DatagramSocket dtagramsocket = new DatagramSocket(9080);
		System.out.println("数据发送");
while(true) {
			byte[] st= new byte[1024];
			DatagramPacket datagramPacket = new DatagramPacket(st, st.length,InetAddress.getLocalHost(),9080);
			dtagramsocket.receive(datagramPacket);
			new ATMServer(dtagramsocket, datagramPacket, st).start();
}			
	}
}
