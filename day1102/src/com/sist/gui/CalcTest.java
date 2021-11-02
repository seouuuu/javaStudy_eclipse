package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcTest extends JFrame implements ActionListener {

	//�μ��� �Է�, ����� ����ϱ����� TextField�� �ɹ������� ����
	JTextField jtf1;
	JTextField jtf2;
	JTextField jtf3;
	
	public CalcTest() {
		
		//TextField ��ü�� ����. �Ű������� ���� �ѹ��� �����ִ� ������ ��
		jtf1 = new JTextField(10);
		jtf2 = new JTextField(10);
		jtf3 = new JTextField(10);
		
		//�������� ���̾ƿ������ FlowLayout���� ����
		setLayout(new FlowLayout());
		
		//���ʴ�� ��,��ư�� �����Ͽ� �����ӿ� ���
		add(new JLabel("��1:"));  //���� ȭ�鿡 ���̱⸸ �ϸ� �Ǵ� �̸��� �� �ʿ�� ����
		add(jtf1);
		add(new JLabel("��2:"));
		add(jtf2);
		
		JButton btnAdd = new JButton("���ϱ�");
		add(btnAdd);
		
		add(new JLabel("���:"));
		add(jtf3);
		
		setSize(600,200);
		setVisible(true);
		
		//��ư�� �̺�Ʈ ���
		//�Ű������� �����ϴ� this�� ��ư�� ���������� ��ó���ϴ� ��� ��ü�� CalcTest �ڽ��̶�� ��
		btnAdd.addActionListener(this);
		
	}
	
	
	public static void main(String[] args) {
		new CalcTest();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//TextFiled jtf1,jtf2�� �� �о����
		int num1 = Integer.parseInt(jtf1.getText());
		int num2 = Integer.parseInt(jtf2.getText());
		int sum = num1 + num2;
		
		jtf3.setText(sum+"");
		
		
	}

}
