package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonTest02 extends JFrame {

	public JButtonTest02() {
		
		//��ư�� �����Ͽ� â�� ���
		JButton btn1 = new JButton("��ư1");
		JButton btn2 = new JButton("��ư2");
		
		add(btn1);
		add(btn2);
		
		setSize(400,300);
		setVisible(true);
		
		//â�� ������ ���α׷��� ���� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	public static void main(String[] args) {
		//�츮�� ���� JButtonTest�� �� JFrame
		//�����ڷ� ����� ��ü�� �����ϱ⸸ �ص� ��
		JButtonTest02 f = new JButtonTest02();
		
	}

}
