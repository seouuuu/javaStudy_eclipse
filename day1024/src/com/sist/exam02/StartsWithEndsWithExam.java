package com.sist.exam02;

import java.util.Scanner;

public class StartsWithEndsWithExam {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڿ��� �Է��ϼ���==>");
		String data = sc.next();
		
		if(data.startsWith("��")) {
			System.out.println("ok");
		}else
			System.out.println("no");
		
		if(data.endsWith("��")) {
			System.out.println("ok");
		}else
			System.out.println("no");
		
		
		}
}
