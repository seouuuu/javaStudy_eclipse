package com.sist.exam04;

import java.util.Scanner;

public class StringTestPwdCheck {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pwd,pwdCheck;
		System.out.println("��ȣ�� �Է��ϼ���==>");
		pwd = sc.next();
		System.out.println("��ȣȮ���� �Է��ϼ���==>");
		pwdCheck = sc.next();
		
		if(pwd.equals(pwdCheck) && pwd.length()>=8 && pwd.length()<=12) {
			System.out.println("�ٶ����� ��ȣ�Դϴ�.");
		}else
			System.out.println("�ٶ����� ��ȣ�� �ƴմϴ�.");
	}
}
