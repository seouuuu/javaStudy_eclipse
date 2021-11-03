package com.sist.echo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UDPChatClient extends JFrame implements ActionListener{

	//UDP방식으로 데이터를 주고받기 위한 DatagramSocket과 DatagramPacket을 맴버변수로 선언
		DatagramSocket socket;
		DatagramPacket packet;
		
	//대화내용을 표시하기 위한 TextArea를 맴버변수로 선언
	JTextArea jta;
	
	//대화내용을 입력하기 위한 TextField를 맴버변수로 선언
	JTextField jtf;
	
	public UDPChatClient() {
		//맴버변수를 생성
		jta = new JTextArea();
		jtf = new JTextField(50);	//한번에 입력할 수 있는 글자수
		
		//전송을 위한 버튼 생성
		JButton btn = new JButton("전송");
		
		//TextFiled와 버튼을 담을 패널 생성
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//TextArea에 스크롤 팬 객체 생성
		JScrollPane jsp = new JScrollPane(jta);
		
		//프레임의 가운데에 TextArea를 감싸고 있는 스크롤팬 담기
		add(jsp,BorderLayout.CENTER);
		
		//프레임의 아래에 TextField와 버튼을 담고 있는 패널을 담기
		add(p,BorderLayout.SOUTH);
		
		//프레임의 크기를 설정
		setSize(800,600);
		
		//화면에 보여주도록 설정
		setVisible(true);
		
		try {
			//데이터를 주고받기 위한 메소드를 가지고 있는 DatagramSocket객체 생성
			socket = new DatagramSocket();
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		//전송버튼에 이벤트를 등록하여 TextField에 입력한 내용을 서버에 전송
		btn.addActionListener(this);
		
		//서버로부터 데이터를 계속 수신하기 위한 스레드클래스를 inner클래스로 만듬
		class ClientThread implements Runnable{
			DatagramPacket packet;
			byte []data = new byte[100];
			
			public void run() {
				
				//데이터를 수신하기 위한 패킷 생성
				packet = new DatagramPacket(data,data.length);
				
				//계속하여 서버로부터 데이터를 수신
				while(true) {
					try {
						//데이터를 수신
						socket.receive(packet);
						
						//서버로부터 수신된 데이터가 있는 배열의 내용을 문자열로 만들기
						String msg = new String(data);
						
						//수신된 문자열을 TextArea에 추가
						jta.append(msg.trim() + "\n");
						
						//다음데이터 수신을 위해 배열을 지워줌
						Arrays.fill(data, (byte)0);
						
					}catch (Exception e) {
						System.out.println("예외발생:"+e.getMessage());
					}
				}//end while
				
			}//end run
		}//end innerclass
		
		//스레드 객체를 생성하고 스레드 가동
		new Thread(new ClientThread()).start();
		
	}//end 생성자

	
	public static void main(String[] args) {
		new UDPChatClient();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
		//사용자가 입력한 대화내용이 있는 TextField의 문자열 가지고 오기
		String msg = jtf.getText();
		
		//UDP 방식으로 데이터 보내려면 패킷 생성해야 함. 문자열을 byte[] 배열로 만들어야 함
		byte []data = msg.getBytes();
		
		//InetAddress 객체 생성
		InetAddress addr = InetAddress.getByName("localhost");
		
		int port = 9005;
		
		//데이터를 보낼 패킷 생성
		packet = new DatagramPacket(data,data.length,addr,port);
		
		//서버로 데이터 전송
		socket.send(packet);
		
		}catch (Exception ex) {
			System.out.println("예외발생:"+ex.getMessage());
		}
	}

}
