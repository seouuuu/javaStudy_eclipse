package com.sist.exam05;

import java.util.Scanner;

public class IdExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//�̸��� �Է¹޾� id �� ����
		String email;
		System.out.print("�̸����� �Է��ϼ���==>");
		email = sc.next();
		System.out.println("���̵�� "+ email.substring(0,email.indexOf("@"))+"�Դϴ�.");
	}
}
