package fream;
/*
 * ����ˣ�����������ݣ����������Լ������������ظ��û���
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
		//��ȡ�����ļ�
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
        //��������		
		String info = new String(string2);
		String[] string = info.split(" ");
		string[0]=string[0].trim();
		string[1]=string[1].trim();
		string[2]=string[2].trim();
		string[3]=string[3].trim();
		string[4]=string[4].trim();
		//��֤�����Ƿ�һ��
		System.out.println("{"+string[0]+"}"+"{"+string[1]+"}"+"{"+string[2]+"}"+"{"+string[3]+"}"+"{"+string[4]+"}");
		System.out.println("{"+Integer.parseInt(string[0])+"}");
		//ע��ҳ��
		if (Integer.parseInt(string[0]) == 1) {
			// �����ڸ��û���,����һ�������ļ�
			if (!pps1.containsKey(string[1])) {
					try {
						pps1.setProperty(string[1], string[2]);
						pps1.store(new FileWriter(file1), "�˻���Ϣ");
						
						pps2.setProperty(string[1], "0");
						pps2.store(new FileWriter(file2), "�˻����");
						
						string[4] = "1";
						datasend(string[0], string[1], string[2], string[3], string[4]);}
				// ע��ɹ�������1������
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
			 else {
				// ��ע����˺��Ѿ�����,����2
				string[4] = "2";

				try {
					datasend(string[0], string[1], string[2], string[3], string[4]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		
		// ��¼ȷ��
		if (string[0].equals("2") ) {
			
			
			// ȷ���Ƿ��и��˻�
			if (pps1.containsKey(string[1]) && pps2.containsKey(string[1])) {
				
				
				// ȷ�ϸ��˻��������Ƿ�һ��
				if (pps1.getProperty(string[1]).equals(string[2])) {
					
					
					// �û��˻�������ȷ����¼�ɹ�
					string[4] = "1";
					try {
						datasend(string[0], string[1], string[2], string[3], string[4]);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					// �û�������󣬵�¼���ɹ�
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
				// û�иÿ��Ŵ���
				string[4] = "3";
				try {
					datasend(string[0], string[1], string[2], string[3], string[4]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} 
		// ��ѯ���
		if (Integer.parseInt(string[0].trim()) == 3) {
			string[3] = pps2.getProperty(string[1]);
			try {
				datasend(string[0], string[1], string[2], string[3], string[4]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		// ���
		if (Integer.parseInt(string[0]) == 4) {
			if (Integer.parseInt(string[3]) >= 0) {
				String acconts = Integer.parseInt(string[3]) + Integer.parseInt(pps2.getProperty(string[1])) + "";
				string[4] = "���ɹ�";
				//string[3] = pps2.getProperty(string[1]);
				string[3] = acconts.trim();
				try {
					pps2.setProperty(string[1], string[3]);
					pps2.store(new FileWriter(file2), "�˻����");
					
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
			string[4] = "��������";
			try {
				datasend(string[0], string[1], string[2], string[3], string[4]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} }// ת��
		if (Integer.parseInt(string[0]) == 5) {
			// ����˻���ȷ
			if (pps2.containsKey(string[4])) {
				// ����˻�������ת�˽��
				if (Integer.parseInt(pps2.getProperty(string[1])) >= Integer.parseInt(string[3])) {
					String other = Integer.parseInt(pps2.getProperty(string[4].trim())) + Integer.parseInt(string[3].trim()) + "";
					String myself = Integer.parseInt(pps2.getProperty(string[1])) - Integer.parseInt(string[3]) + "";
					pps2.setProperty(string[4], other);
					pps2.setProperty(string[1], myself);
					try {
						pps2.store(new FileWriter(file2), "�˻����");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					string[4] = "ת�˳ɹ�";
					try {
						datasend(string[0], string[1], string[2], string[3], string[4]);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				} // С��ת�˽�����ת��
				else {
					string[4] = "��������";
					try {
						datasend(string[0], string[1], string[2], string[3], string[4]);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
			}
			}
		// û��ת���û�����
		else {
			string[4] = "û�и��˻�������������";
			try {
				datasend(string[0], string[1], string[2], string[3], string[4]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}}
		// ȡ��
		if (Integer.parseInt(string[0]) == 6) {
			// ����˻�������ȡ����
			if (Integer.parseInt(pps2.getProperty(string[1])) >= Integer.parseInt(string[3])) {
				int name1=Integer.parseInt(pps2.getProperty(string[1]));
				int name2=Integer.parseInt(string[3]);
				String myself = String.valueOf(name1-name2);
				System.out.println(myself);
				pps2.setProperty(string[1], myself.trim());
					try {
						pps2.store(new FileWriter(file2), "�˻����");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				try {
					string[3] = myself;
				    string[4] = "ȡ��ɹ�";
					
					datasend(string[0], string[1], string[2], string[3], string[4]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// �˻����С��ת�˽�����ת��
			else {
				string[4] = "��������";
				try {
					datasend(string[0], string[1], string[2], string[3], string[4]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} // �޸�����
		if (Integer.parseInt(string[0]) == 7) {
			pps1.setProperty(string[1], string[3]);
	
		    try {
				pps1.store(new FileWriter(file1), "�˻���Ϣ");
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
		//�������ݸ��ͻ��ˣ��������˿ں�
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
		//ѭ����������
		DatagramSocket dtagramsocket = new DatagramSocket(9080);
		System.out.println("���ݷ���");
while(true) {
			byte[] st= new byte[1024];
			DatagramPacket datagramPacket = new DatagramPacket(st, st.length,InetAddress.getLocalHost(),9080);
			dtagramsocket.receive(datagramPacket);
			new ATMServer(dtagramsocket, datagramPacket, st).start();
}			
	}
}
