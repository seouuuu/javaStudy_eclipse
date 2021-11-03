package com.sist.inner;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//버튼에 대한 이벤트 처리를 위해서는 ActionListener 인터페이스를 구현해야함
//MyFrame자신이 ActionListener 인터페이스를 구현하면 하나의 actionPerformed 메소드에서 모든 버튼 이벤트처리해야함.if문 복잡해짐
//그래서 버튼하나당 일처리 담당객체를 이름없는 inner클래스로 만들어 처리

public class MyFrame extends JFrame {

	public MyFrame() {
		JButton btn1 = new JButton("남자");
		JButton btn2 = new JButton("여자");
		setLayout(new FlowLayout());
		
		add(btn1);
		add(btn2);
	
		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("남자입니다.");
			}
			
		});
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("여자입니다.");
			}
			
		});
	}
	
	public static void main(String[] args) {
		new MyFrame();

	}
}
