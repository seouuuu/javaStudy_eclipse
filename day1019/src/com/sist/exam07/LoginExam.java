package com.sist.exam07;

import java.util.Scanner;

public class LoginExam {

	public static void main(String[] args) {
		//관리자 아이디암호 입력받아 로그인 처리
		Scanner sc = new Scanner(System.in);
		String id = "tiger";
		String pwd = "tiger1234";
		
		String input_id,input_pwd;
		System.out.println("아이디를 입력하세요==>");
		input_id = sc.next();
		
		System.out.println();
		
		System.out.println("비밀번호를 입력하세요==>");
		input_pwd = sc.next();
		
		if(id.equals(input_id) && pwd.equals(input_pwd)) {
			System.out.println("로그인에 성공하였습니다.");
		} else
			System.out.println("로그인에 실패하였습니다.");

	}

}
