package com.sist.net;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.awt.BorderLayout;

public class URLTestFrame extends JFrame implements ActionListener{

	//url을 입력받기 위한 텍스트필드를 맴버변수로 만들기
	JTextField jtf;
	
	//url의 문서의 내용을 긁어와서 출력하기 위한 textArea를 맴버변수로 만들기
	JTextArea jta;
	
	public URLTestFrame() {
		//맴버변수 TextField와 TextArea객체를 생성
		jtf = new JTextField(50); //사이즈설정 해도되고 안해도 됨.안하면 작게 만들어짐
		jta = new JTextArea();
		
		//읽어오기를 수행시킬 버튼 생성
		JButton btn = new JButton("읽어오기");
		
		//TextField와 버튼을 담기위한 패널생성
		JPanel p = new JPanel();
		
		//패널에 TextFiled와 버튼 담기
		p.add(jtf);
		p.add(btn);
		
		//TextArea를 감싸기 위한 스크롤팬을 생성
		JScrollPane jsp = new JScrollPane(jta);
		
		//TextFiled와 버튼을 담고 있는 패널을 프레임의 위쪽에 담기
		add(p, BorderLayout.NORTH);
		
		//TextArea를 감싸고 있는 스크롤팬을 프레임 가운데에 담기
		add(jsp, BorderLayout.CENTER);
		
		//프레임의 크기 설정
		setSize(800,600);
		
		//프레임을 화면에 보이도록 설정
		setVisible(true);
		
		//버튼에 이벤트 등록
		btn.addActionListener(this);
		
		
	}
	
	public static void main(String[] args) {
		new URLTestFrame();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			//사용자가 입력한 인터넷주소를 읽어와서 객체 생성
			URL url = new URL(jtf.getText());
			
			//문서의 내용을 읽어오기 위해 스트림 생성
			InputStream is =  url.openStream();
			
			//한꺼번에 읽어들일 byte형의 배열을 만들기
			byte []data = new byte[100];
			
			//스트림을 통해 읽어온 문자열을 다 모아놓을 변수를 만들기
			String str = "";
			
			//스트림의 끝이 아닐때까지 100바이트씩 읽어들임
			while( is.read(data) != -1 ) {
				
				//읽어들인 byte배열의 데이터를 문자열로 만들어 누적
				str += new String(data,"utf-8");
				
				//배열을 다시 읽어들이기 전에 깨끗이 비우기
				//그렇지 않으면 맨끝에 이상한 쓰레기가 출력될 수 있음
				//byte형의 배열 data를 모두 0으로 초기화
				//숫자 0이오면 자바는 int로 취급하기 때문에 byte으로 형변환함
				Arrays.fill(data, (byte)0);
			}
			
			//전체누적된 문자열 변수를 TextArea에 출력
			jta.setText(str);
			
			//스트림 닫기
			is.close();
			
		}catch (Exception ex) {
			System.out.println("예외발생:"+ex.getMessage());
		}
		
	}

}
