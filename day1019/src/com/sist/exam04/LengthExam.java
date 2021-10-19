package com.sist.exam04;

import java.util.Scanner;

public class LengthExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data,data2;
		
		System.out.print("암호를 입력하세요==>");
		data = sc.next();
		
		while(data.length()<8 && data.length()>12) {
			System.out.print("암호를 입력하세요==>");
			data = sc.next();
		}	
		
		System.out.print("암호확인을 위해 한번더 입력하세요==>");
		data2 = sc.next();
		
		while(data2.length()<8 && data.length()>12) {
			System.out.print("암호확인을 위해 한번더 입력하세요==>");
			data2 = sc.next();
		} 
		
		if(data.equals(data2)) {
			System.out.println("암호가 동일합니다.");
		}else
			System.out.println("암호가 동일하지 않습니다.");
	}
}
