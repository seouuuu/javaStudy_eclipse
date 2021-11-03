package com.sist.chat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatClient extends JFrame implements ActionListener{

	//대화내용을 출력할 TextArea를 맴버변수로 만들기
	JTextArea jta;
	
	//대화내용을 입력할 TextField를 맴버변수로 만들기
	JTextField jtf;
	
	//입출력스트림을 맴버변수로 만들기
	InputStream is;
	OutputStream os;
	
	public ChatClient(){
		
		//맴버변수 TextArea와 TextField를 생성
		jta = new JTextArea();
		jtf = new JTextField();
		
		//전송을 위한 버튼 생성
		JButton btn = new JButton("전송");
		
		//버튼에 이벤트 등록
		btn.addActionListener(this);
		
		//TextField와 버튼을 담기위한 패널 생성
		JPanel p = new JPanel();
		
		//패널의 레이아웃방식 BorderLayout으로 변경
		p.setLayout(new BorderLayout());
		
		p.add(jtf, BorderLayout.CENTER);
		p.add(btn, BorderLayout.EAST);
		
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
		
		setTitle("YOON TALK");
		
		try {
			//통신을 위해 서버에 접속을 요청
			Socket socket = new Socket("localhost",9003);
			
			//입출력을 위한 스트림 생성
			is = socket.getInputStream();
			os = socket.getOutputStream();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		//서버가 보내오는 데이터를 버튼과 상관없이 계속하여 받기위한 스레드 클래스를 생성
		//inner클래스는 마치 outterclass의 맴버처럼 동작
		//outter클래스의 맴버에 자유롭게 접근 할 수 있음
		class ClientThread extends Thread{
			byte []data = new byte[100];
			public void run() {
				while(true) {
					try {
						//서버가 보내온 데이터를 수신
						is.read(data);
						
						//수신한 데이터를 문자열로 만들기
						String msg = new String(data);
						
						//수신한 문자열을 TextArea에 추가
						jta.append(msg.trim()+"\n");
						
					}catch (Exception e) {
						System.out.println("예외발생:"+e.getMessage());
					}
				}
			}//end run
		}//end innerclass
		
		//서버로부터 계속하여 수신된 메세지를 받기위한 스레드 객체 생성하고 가동
		ClientThread ct = new ClientThread();
		ct.start();
		
	}//end 생성자
	
	public static void main(String[] args) {
		new ChatClient();
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


