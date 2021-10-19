package com.sist.exam06;

import java.util.Scanner;

public class SmalloExam {

	public static void main(String[] args) {
		
		//영문의 문장 입력받아 소문자 'o'의 개수 출력
		Scanner sc = new Scanner(System.in);
		int cnt=0;
		String data;
		
		System.out.print("영문장을 입력하세요==>");
		data = sc.nextLine();          //sc.next(); 오류
		
		for(int i=0;i<data.length();i++) {
			if(data.charAt(i)=='o') {
				cnt++;
			}
		}
		
		System.out.println("소문자 o의 개수: "+cnt);
		
	}

}
