package com.sist.gui;

import javax.swing.JFrame;

public class JButtonTest extends JFrame {

	public JButtonTest() {
		
	}
	
	public static void main(String[] args) {
		//우리가 만든 JButtonTest가 곧 JFrame
		JButtonTest f = new JButtonTest();
		
		f.setSize(400,300);
		f.setVisible(true);
		
		//창을 닫으면 프로그램도 같이 종료
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
