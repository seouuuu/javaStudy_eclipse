package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class BorderLayoutTest02 extends JFrame {

	public BorderLayoutTest02() {
		//�������� BorderLayout���� ����
		setLayout(new BorderLayout());
		
		//�ټ����� ��ư�� �����Ͽ� ��,�Ʒ�,��,��,����� ���
		//add(new JButton("��"),BorderLayout.NORTH);
		//add(new JButton("�Ʒ�"),BorderLayout.SOUTH);
		//add(new JButton("��"),BorderLayout.WEST);
		add(new JButton("��"),BorderLayout.EAST);
		add(new JButton("���"),BorderLayout.CENTER);
		
		setSize(400,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new BorderLayoutTest02();

	}

}
