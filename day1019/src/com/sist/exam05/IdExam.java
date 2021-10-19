package com.sist.exam05;

import java.util.Scanner;

public class IdExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//이메일 입력받아 id 만 추출
		String email;
		System.out.print("이메일을 입력하세요==>");
		email = sc.next();
		System.out.println("아이디는 "+ email.substring(0,email.indexOf("@"))+"입니다.");
	}
}
