package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class GridLayoutTest03 extends JFrame {

	public GridLayoutTest03() {
		//�������� 5�� 3�� �׸��巹�̾ƿ����� ����
		setLayout(new GridLayout(5,4));
		
		//�ݺ����� �̿��Ͽ� 15���� ��ư ���� �� �����ӿ� ���
		for(int i=1; i<=9;i++) {
			add(new JButton("��ư"+i));
		}
		
		setSize(400,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new GridLayoutTest03();

	}

}
