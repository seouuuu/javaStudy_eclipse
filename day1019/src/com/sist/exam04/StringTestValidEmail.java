package com.sist.exam04;

import java.util.Scanner;

public class StringTestValidEmail {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String email;
		System.out.print("이메일을 입력하세요==>");
		email = scanner.next();
		if(email.indexOf("@") != -1) {
			System.out.println("올바른 이메일입니다.");
		}else {
			System.out.println("올바른 이메일이 아닙니다.");
		}
	}
}
