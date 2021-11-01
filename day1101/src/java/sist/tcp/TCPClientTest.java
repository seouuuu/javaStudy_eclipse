package java.sist.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClientTest {

	public static void main(String[] args) {
		
		try {
			//1. 서버에 통신 요청
			Socket socket = new Socket("172.30.1.4",9001);
			//Socket socket = new Socket("127.0.0.1",9001);
			//Socket socket = new Socket("localhost",9001);
			
			//2. 소켓을 통해 데이터를 주고 받을 스트림 생성
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			//3. 스트림을 통해 데이터를 주고 받음
			//서버가 보내오는 10개의 정수를 읽어들여 화면에 출력
			for(int i=1; i<=10; i++) {
				int n = is.read();
				System.out.println("서버로 부터 수신된 데이터:"+n);
				Thread.sleep(100);
			}
			
			//4. 사용했던 자원을 닫아 줌
			is.close();
			os.close();
			socket.close();
			
			
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}

	}
}
