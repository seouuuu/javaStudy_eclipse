package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcTest extends JFrame implements ActionListener {

	//두수를 입력, 결과를 출력하기위한 TextField를 맴버변수로 선언
	JTextField jtf1;
	JTextField jtf2;
	JTextField jtf3;
	
	public CalcTest() {
		
		//TextField 객체를 생성. 매개변수의 값은 한번에 보여주는 글자의 수
		jtf1 = new JTextField(10);
		jtf2 = new JTextField(10);
		jtf3 = new JTextField(10);
		
		//프레임의 레이아웃방식을 FlowLayout으로 설정
		setLayout(new FlowLayout());
		
		//차례대로 라벨,버튼을 생성하여 프레임에 담기
		add(new JLabel("수1:"));  //라벨은 화면에 보이기만 하면 되니 이름을 줄 필요는 없음
		add(jtf1);
		add(new JLabel("수2:"));
		add(jtf2);
		
		JButton btnAdd = new JButton("더하기");
		add(btnAdd);
		
		add(new JLabel("결과:"));
		add(jtf3);
		
		setSize(600,200);
		setVisible(true);
		
		//버튼에 이벤트 등록
		//매개변수로 전달하는 this는 버튼이 눌러졌을때 일처리하는 담당 객체가 CalcTest 자신이라는 것
		btnAdd.addActionListener(this);
		
	}
	
	
	public static void main(String[] args) {
		new CalcTest();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//TextFiled jtf1,jtf2의 값 읽어오기
		int num1 = Integer.parseInt(jtf1.getText());
		int num2 = Integer.parseInt(jtf2.getText());
		int sum = num1 + num2;
		
		jtf3.setText(sum+"");
		
		
	}

}
