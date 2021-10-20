package com.sist.exam03;

import java.util.Scanner;

public class StringExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열을 입력하세요.");
		String data = sc.next();
		data = data.replace("hello","안녕");
		System.out.println(data);
	}
}
