package com.sist.exam04;
import java.util.Scanner;
public class StringExam {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data;
		System.out.println("�̸����� �Է��ϼ���==>");
		data = sc.next();
		int index = data.indexOf("@");
		if (index == -1) {
			System.out.println("�ùٸ� �̸����� �ƴմϴ�.");
		}else
			System.out.println("�ùٸ� �̸����Դϴ�.");
	}
}
