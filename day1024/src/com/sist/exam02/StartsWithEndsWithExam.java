package com.sist.exam02;

import java.util.Scanner;

public class StartsWithEndsWithExam {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열을 입력하세요==>");
		String data = sc.next();
		
		if(data.startsWith("가")) {
			System.out.println("ok");
		}else
			System.out.println("no");
		
		if(data.endsWith("하")) {
			System.out.println("ok");
		}else
			System.out.println("no");
		
		
		}
}
