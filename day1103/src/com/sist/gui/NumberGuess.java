package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.Color;

public class NumberGuess extends JFrame implements ActionListener{

	JTextField jtf;
	
	JTextField result;
	
	//��ǻ�Ͱ� ������ ������ �����ϱ� ���� ������ �ɹ������� ����
	int num;
	
	public NumberGuess() {
		
		//���� ���� �� �ɹ����� num�� ����
		Random r = new Random();
		num = r.nextInt(100)+1;
		
		jtf = new JTextField(10);
		result = new JTextField("                        ���⿡ ����� ��Ÿ���ϴ�.                       ");
		
		//�������� ��ġ����� FlowLayout���� ����
		setLayout(new FlowLayout());
		
		//ȭ�鿡 ������ҵ��� ���
		add(new JLabel("���ڸ� �����Ͻÿ�"));
		add(jtf);
		add(result);
		
		//�ΰ��� ��ư ����
		JButton btn1 = new JButton("�ٽ� �ѹ�");
		JButton btn2 = new JButton("����");
		add(btn1);
		add(btn2);
		
		setSize(300,300);
		setVisible(true);
		
		//â�� ������ ���α׷� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//ũŰ ���� ���ϵ��� ����
		setResizable(false);
		
		//�� ��ư�� �̺�Ʈ ���
		btn1.addActionListener(this);
		btn2.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new NumberGuess();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//�ٽ��ѹ�,���� ��ư�� ������ �ش� �޼ҵ� ����
		String cmd = e.getActionCommand();
		if(cmd.equals("�ٽ� �ѹ�")) {
			//��ǻ�Ͱ� �����ϰ� �ִ� ������ ����ڰ� �Է��� ���ڰ� �������� �Ǻ�
		
			//����ڰ� �Է��� ���ڸ� ������ ��
			int user = Integer.parseInt(jtf.getText());
			
			//������,�ٸ���,�� ������ �Ǻ��Ͽ� ��� ���
			if(user == num) {
				result.setText("                        �����Դϴ�.                       ");
				result.setBackground(Color.blue);
			}else if(user > num) {
				result.setText("                      �� ū ���ڸ� �Է��߽��ϴ�.                       ");
				jtf.setText("");
				result.setBackground(Color.red);
			}else {
				result.setText("                      �� ���� ���ڸ� �Է��߽��ϴ�.                       ");
				jtf.setText("");
				result.setBackground(Color.red);
			}
			
		}else if(cmd.equals("����")) {
			System.exit(0);
		}
			
	}

}
