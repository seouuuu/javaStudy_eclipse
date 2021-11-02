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
	int num1;	//연산을 위한 첫번째 수를 담을 변수
	int num2;	//연산을 위한 두번째 수를 담을 변수
	String op="";	//어떤연산을 할지 담을 변수
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
		setTitle("계산기");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new CalcTest02();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 글자를 읽어옴
		String cmd = e.getActionCommand();
		//System.out.println(cmd);
		
		
		if(cmd.equals("+") || cmd.equals("-") || cmd.equals("*") || cmd.equals("/") ) {
			//화면에 보이는 숫자를 변수(num1)에 저장
			num1 = Integer.parseInt(result.getText());
			//어떤연산을 해야할지 변수(op)에 저장
			op = cmd;
			//화면을 지움
			result.setText("");
			
		}else if(cmd.equals("=")) {
			//지금 화면에 보이고 있는 숫자를 변수(num2)에 저장
			num2 = Integer.parseInt(result.getText());
			//op의 연산자종류에 따라 num1,num2를 해당연산을 수행하여 result에 출력
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
			//화면 지우기
			result.setText("");
		}else {
			
			//눌러진 버튼의 글자를 TextField에 계속 누적하여 출력
			result.setText(result.getText() + cmd);
		}
		
		
		
	}
}
