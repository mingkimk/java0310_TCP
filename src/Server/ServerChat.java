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
			id= id.trim(); //  트림 공백 제거
			
			InetAddress c_ip= withClient.getInetAddress();
			//withClient 라는 소캣으로 getInetAddress 을 받아서 c_ip에 저장
			String ip=c_ip.getHostAddress();
			//c_ip를 string으로 변경
			System.out.println(id+"님 로그인 하셨습니다");
			
			
			
			
	
			String reMsg="정상접속 되었습니다";
			sendMsg= withClient.getOutputStream();
			sendMsg.write(reMsg.getBytes());
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
