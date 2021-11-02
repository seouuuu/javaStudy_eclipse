package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest02 extends JFrame {

	public JButtonTest02() {
		
		//버튼을 생성하여 창에 담기
		JButton btn1 = new JButton("버튼1");
		JButton btn2 = new JButton("버튼2");
		
		add(btn1);
		add(btn2);
		
		setSize(400,300);
		setVisible(true);
		
		//창을 닫으면 프로그램도 같이 종료
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public static void main(String[] args) {
		//우리가 만든 JButtonTest가 곧 JFrame
		//생성자로 만들면 객체를 생성하기만 해도 됨
		JButtonTest02 f = new JButtonTest02();
		
	}

}
