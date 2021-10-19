package com.sist.exam04;
import java.util.Scanner;
public class StringExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data;
		System.out.println("이메일을 입력하세요==>");
		data = sc.next();
		int index = data.indexOf("@");
		if (index == -1) {
			System.out.println("올바른 이메일이 아닙니다.");
		}else
			System.out.println("올바른 이메일입니다.");
	}
}
