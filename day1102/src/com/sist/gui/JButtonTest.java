package com.sist.gui;

import javax.swing.JFrame;

public class JButtonTest extends JFrame {

	public JButtonTest() {
		
	}
	
	public static void main(String[] args) {
		//�츮�� ���� JButtonTest�� �� JFrame
		JButtonTest f = new JButtonTest();
		
		f.setSize(400,300);
		f.setVisible(true);
		
		//â�� ������ ���α׷��� ���� ����
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
