package com.sist.exam03;

import java.util.Scanner;

public class StringExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڿ��� �Է��ϼ���.");
		String data = sc.next();
		data = data.replace("hello","�ȳ�");
		System.out.println(data);
	}
}
