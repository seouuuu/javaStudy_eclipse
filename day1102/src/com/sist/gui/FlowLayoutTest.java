package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class FlowLayoutTest extends JFrame {

	public FlowLayoutTest() {
		
		//프레임에 FlowLayout 설정
		setLayout(new FlowLayout());
		
		//반복문을 이용하여 버튼 15개 생성하여 프레임에 담기
		for(int i=1;i<=15;i++) {
			add(new JButton("버튼"+i));
		}
		
		//프레임에 크기 설정,화면에 보이도록 설정
		setSize(400,300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new FlowLayoutTest();
	}
}
