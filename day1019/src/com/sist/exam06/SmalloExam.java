package com.sist.exam06;

import java.util.Scanner;

public class SmalloExam {

	public static void main(String[] args) {
		
		//������ ���� �Է¹޾� �ҹ��� 'o'�� ���� ���
		Scanner sc = new Scanner(System.in);
		int cnt=0;
		String data;
		
		System.out.print("�������� �Է��ϼ���==>");
		data = sc.nextLine();          //sc.next(); ����
		
		for(int i=0;i<data.length();i++) {
			if(data.charAt(i)=='o') {
				cnt++;
			}
		}
		
		System.out.println("�ҹ��� o�� ����: "+cnt);
		
	}

}
