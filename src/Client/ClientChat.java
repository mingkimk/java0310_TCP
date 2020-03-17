package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {

	private Socket withServer = null;
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	private String id = null;
	Scanner input = new Scanner(System.in);
	ClientChat(Socket c) {
		this.withServer = c;
		streamSet();
	}
	private void streamSet() {
		// sendMsg= withServer.getOutputStream(); 정보 가 올때까지 대기 상태
		try {
			System.out.println("ID 를 입력 하세요");
			id= input.nextLine();
			sendMsg= withServer.getOutputStream();
			sendMsg.write(id.getBytes());
			
			reMsg= withServer.getInputStream();
			byte[] reBuffer= new byte[100];
			reMsg.read(reBuffer);
			String msg= new String(reBuffer);
			msg=msg.trim();
			System.out.println(msg);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
