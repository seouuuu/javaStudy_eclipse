package com.sist.exam07;

import java.util.Scanner;

public class LoginExam {

	public static void main(String[] args) {
		//������ ���̵��ȣ �Է¹޾� �α��� ó��
		Scanner sc = new Scanner(System.in);
		String id = "tiger";
		String pwd = "tiger1234";
		
		String input_id,input_pwd;
		System.out.println("���̵� �Է��ϼ���==>");
		input_id = sc.next();
		
		System.out.println();
		
		System.out.println("��й�ȣ�� �Է��ϼ���==>");
		input_pwd = sc.next();
		
		if(id.equals(input_id) && pwd.equals(input_pwd)) {
			System.out.println("�α��ο� �����Ͽ����ϴ�.");
		} else
			System.out.println("�α��ο� �����Ͽ����ϴ�.");

	}

}
