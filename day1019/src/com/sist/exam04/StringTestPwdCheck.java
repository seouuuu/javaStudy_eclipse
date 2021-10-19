package com.sist.exam04;

import java.util.Scanner;

public class StringTestPwdCheck {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String pwd,pwdCheck;
		System.out.println("암호를 입력하세요==>");
		pwd = sc.next();
		System.out.println("암호확인을 입력하세요==>");
		pwdCheck = sc.next();
		
		if(pwd.equals(pwdCheck) && pwd.length()>=8 && pwd.length()<=12) {
			System.out.println("바람직한 암호입니다.");
		}else
			System.out.println("바람직한 암호가 아닙니다.");
	}
}
