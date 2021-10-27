package com.sist.game;

import javax.swing.JFrame;

//GUI(Graphic User InterFace) 프로그래밍에서 창을 만들기 위해 JFrame을 상속
public class MyFrame extends JFrame {

	//생성자에서
	public MyFrame() {
		setTitle("My Game");		//창의 제목을 설정
		add(new MyPanel());			//적,미사일,우주선을 포함하고있는 패널을 생성하여 프레임에 담기
		setSize(500,500);			//프레임의 크기 설정
		setVisible(true);			//프레임을 화면에 보이도록 설정
	}
	
	public static void main(String[] args) {
		new MyFrame();				//프레임을 생성
	}
}
