package com.sist.inner;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//��ư�� ���� �̺�Ʈ ó���� ���ؼ��� ActionListener �������̽��� �����ؾ���
//MyFrame�ڽ��� ActionListener �������̽��� �����ϸ� �ϳ��� actionPerformed �޼ҵ忡�� ��� ��ư �̺�Ʈó���ؾ���.if�� ��������
//�׷��� ��ư�ϳ��� ��ó�� ��簴ü�� �̸����� innerŬ������ ����� ó��

public class MyFrame extends JFrame {

	public MyFrame() {
		JButton btn1 = new JButton("����");
		JButton btn2 = new JButton("����");
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
				System.out.println("�����Դϴ�.");
			}
			
		});
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("�����Դϴ�.");
			}
			
		});
	}
	
	public static void main(String[] args) {
		new MyFrame();

	}
}
