package com.sist.echo03;

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
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UDPChatClient extends JFrame implements ActionListener, Runnable{

	//대화내용을 출력할 TextArea를 맴버변수로 만들기
	JTextArea jta;
	
	//대화내용을 입력할 TextField를 맴버변수로 만들기
	JTextField jtf;
	
	//입출력스트림을 맴버변수로 만들기
	DatagramSocket ds;
	DatagramPacket dp;
	
	public UDPChatClient(){
		
		//맴버변수 TextArea와 TextField를 생성
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		//전송을 위한 버튼 생성
		JButton btn = new JButton("전송");
		
		//버튼에 이벤트 등록
		btn.addActionListener(this);
		
		//TextField와 버튼을 담기위한 패널 생성
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//TextArea를 Scrollpane으로 감싸기
		JScrollPane jsp = new JScrollPane(jta);
		
		//프레임의 가운데 TextArea를 감싸고 있는 Scrollpane을 담기
		add(jsp,BorderLayout.CENTER);
		
		//TextField와 버튼을 담고 있는 패널을 프레임의 아래애 담기
		add(p,BorderLayout.SOUTH);
		
		//프레임의 크기 설정
		setSize(800,600);
		
		//프레임이 화면에 보이도록 설정
		setVisible(true);
		
		
		
	
		//Runnable은 Thread로 포장
		Thread t = new Thread(this);
		t.start();
		
	}//end 생성자
	
	public static void main(String[] args) {
		DatagramSocket socket;
		DatagramPacket receiver,sender;
		InetAddress ia;
		int port;
		String ip;
		BufferedReader br;
		
		try {
			ip = args[0];
			port = Integer.parseInt(args[1]);
			
			ia = InetAddress.getByName(ip);
			socket = new DatagramSocket();
			br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				String msg = "";
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//사용자가 입력한 TextField의 내용을 서버로 보내기
			//OutputStream void write(byte[] b) 메소드 이용
			byte []data = jtf.getText().getBytes();
			os.write(data);
			
			//메세지 전송하고 다음 메세지 입력을 위해 TextField를 깨끗이 지우기
			jtf.setText("");
			
		}catch(Exception ex){
			System.out.println("예외발생:"+ex.getMessage());
		}
	}

	

	}
}
