package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Color;

public class NumberGuess extends JFrame implements ActionListener{

	JTextField jtf;
	
	JTextField result;
	
	//컴퓨터가 생각할 난수를 저장하기 위한 변수를 맴버변수로 선언
	int num;
	
	public NumberGuess() {
		
		//난수 생성 후 맴버변수 num에 저장
		Random r = new Random();
		num = r.nextInt(100)+1;
		
		jtf = new JTextField(10);
		result = new JTextField("                        여기에 결과가 나타납니다.                       ");
		
		//프레임의 배치방식을 FlowLayout으로 설정
		setLayout(new FlowLayout());
		
		//화면에 구성요소들을 담기
		add(new JLabel("숫자를 추측하시오"));
		add(jtf);
		add(result);
		
		//두개의 버튼 생성
		JButton btn1 = new JButton("다시 한번");
		JButton btn2 = new JButton("종료");
		add(btn1);
		add(btn2);
		
		setSize(300,300);
		setVisible(true);
		
		//창을 닫으면 프로그램 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//크키 변경 못하도록 설정
		setResizable(false);
		
		//두 버튼에 이벤트 등록
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new NumberGuess();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//다시한번,종료 버튼을 누르면 해당 메소드 동작
		String cmd = e.getActionCommand();
		if(cmd.equals("다시 한번")) {
			//컴퓨터가 생각하고 있는 난수와 사용자가 입력한 숫자가 동일한지 판별
		
			//사용자가 입력한 숫자를 가지고 옴
			int user = Integer.parseInt(jtf.getText());
			
			//같은지,다른지,더 작은지 판별하여 결과 출력
			if(user == num) {
				result.setText("                        정답입니다.                       ");
				result.setBackground(Color.blue);
			}else if(user > num) {
				result.setText("                      더 큰 숫자를 입력했습니다.                       ");
				jtf.setText("");
				result.setBackground(Color.red);
			}else {
				result.setText("                      더 작은 숫자를 입력했습니다.                       ");
				jtf.setText("");
				result.setBackground(Color.red);
			}
			
		}else if(cmd.equals("종료")) {
			System.exit(0);
		}
			
	}

}
