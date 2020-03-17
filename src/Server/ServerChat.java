package Server;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerChat {
	
	private Socket withClient=null; 
	private InputStream reMsg= null;
	private OutputStream sendMsg= null;
	private String id= null;
	
	
	ServerChat(Socket c){
		this.withClient=c;
		streamSet();
	}
	private void streamSet() {
		try {
			reMsg= withClient.getInputStream();
			byte[] reBuffer= new byte[100];
			reMsg.read(reBuffer);
			id= new String(reBuffer);
			id= id.trim(); //  Ʈ�� ���� ����
			
			InetAddress c_ip= withClient.getInetAddress();
			//withClient ��� ��Ĺ���� getInetAddress �� �޾Ƽ� c_ip�� ����
			String ip=c_ip.getHostAddress();
			//c_ip�� string���� ����
			System.out.println(id+"�� �α��� �ϼ̽��ϴ�");
			
			
			
			
	
			String reMsg="�������� �Ǿ����ϴ�";
			sendMsg= withClient.getOutputStream();
			sendMsg.write(reMsg.getBytes());
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
