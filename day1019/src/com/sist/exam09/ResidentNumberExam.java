package com.sist.exam09;

import java.util.Scanner;

//������������ - ��������������
//�� = 11-{(2����+3����+4����+5����+6����+7����+8����+9����+2����+3����+4����+5����) mod 11}
//�Ұ�ȣ �ȿ� �ִ� ���� ����� ���� 11�� ������ ���� �������� 11���� �� ���� ���̴�. 

public class ResidentNumberExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�ֹι�ȣ�� �Է��ϼ���xxxxxx-xxxxxxx==>");
		String num = sc.next();
		
		int data;
		data = 11-((2*(num.charAt(0)-48)
				+ 3*(num.charAt(1)-48)
				+ 4*(num.charAt(2)-48)
				+ 5*(num.charAt(3)-48)
				+ 6*(num.charAt(4)-48)
				+ 7*(num.charAt(5)-48) //num.charAt(6)�� ����
				+ 8*(num.charAt(7)-48)
				+ 9*(num.charAt(8)-48)
				+ 2*(num.charAt(9)-48)
				+ 3*(num.charAt(10)-48)
				+ 4*(num.charAt(11)-48)
				+ 5*(num.charAt(12)-48)) % 11);
		if(data == num.charAt(13)-48) {
			System.out.println("�ùٸ� �ֹε�Ϲ�ȣ�Դϴ�.");
		}
		else
			System.out.println("�ùٸ��� ���� �ֹε�Ϲ�ȣ�Դϴ�.");	
	}
}
