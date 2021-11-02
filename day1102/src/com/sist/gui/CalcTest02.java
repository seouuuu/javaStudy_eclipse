package com.sist.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcTest02 extends JFrame implements ActionListener{

	JTextField result ;
	int num1;	//������ ���� ù��° ���� ���� ����
	int num2;	//������ ���� �ι�° ���� ���� ����
	String op="";	//������� ���� ���� ����
	int data;
	
	public CalcTest02() {
		result = new JTextField();
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,4));
		
		String []arr = {"7","8","9","+",
						"4","5","6","-",
						"1","2","3","*",
						"0","c","=","/"};
		
		JButton []btn = new JButton[arr.length];
		
		for(int i=0;i<btn.length;i++) {
			btn[i] = new JButton(arr[i]);
			p.add(btn[i]);
			btn[i].addActionListener(this);
		}
		
		setLayout(new BorderLayout());
		add(result,BorderLayout.NORTH);
		add(p,BorderLayout.CENTER);
		
		setSize(300,400);
		setVisible(true);
		setTitle("����");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new CalcTest02();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//������ ��ư�� ���ڸ� �о��
		String cmd = e.getActionCommand();
		//System.out.println(cmd);
		
		
		if(cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/") ) {
			//ȭ�鿡 ���̴� ���ڸ� ����(num1)�� ����
			num1 = Integer.parseInt(result.getText());
			//������� �ؾ����� ����(op)�� ����
			op = cmd;
			//ȭ���� ����
			result.setText("");
			
		}else if(cmd.equals("=")) {
			//���� ȭ�鿡 ���̰� �ִ� ���ڸ� ����(num2)�� ����
			num2 = Integer.parseInt(result.getText());
			//op�� ������������ ���� num1,num2�� �ش翬���� �����Ͽ� result�� ���
			if(op.equals("+")) {
				data = num1 + num2;
			}else if(op.equals("-")) {
				data = num1 - num2;
			}else if(op.equals("*")) {
				data = num1 * num2;
			}else if(op.equals("/")) {
				data =num1 /num2;
			}
			result.setText(Integer.toString(data));
			
		}else if(cmd.equals("c")) {
			//ȭ�� �����
			result.setText("");
		}else {
			
			//������ ��ư�� ���ڸ� TextField�� ��� �����Ͽ� ���
			result.setText(result.getText() + cmd);
		}
		
		
		
	}
}
