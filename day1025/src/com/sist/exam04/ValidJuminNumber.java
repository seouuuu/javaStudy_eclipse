package com.sist.exam04;

import java.util.Scanner;

public class ValidJuminNumber {

	public static void main(String[] args) {
		String jumin;
		Scanner sc = new Scanner(System.in);
		System.out.println("주민번호를 입력하세요xxxxxx-xxxxxxx==>");
		jumin = sc.next();
		
		int []n = {2,3,4,5,6,7,0,8,9,2,3,4,5};
		//인덱스 6번째는 계산 참여x
		//문자열의 길이는 14자
		//반복실행해야할 인덱스는 12   i<jumin.length()-1
		
		int sum = 0;
		for(int i=0; i<jumin.length()-1;i++) {
			if(i != 6) {
				sum = sum+Integer.parseInt(jumin.charAt(i)+"")*n[i];
				//charAt()의 결과는 char
				//char를 문자열(String)으로 만들기 위해 +""
			}
		}
		sum = sum % 11;
		sum = 11 - sum;
		if(sum == 10) {
			sum = 0;
		}
		if(sum == 11) {
			sum = 1;
		}
		
		int check = Integer.parseInt(jumin.charAt(13)+"");
		
		if(sum == check) {
			System.out.println("올바른 주민등록번호입니다.");
		}else {
			try {
				throw new InValidJuminNumberException("올바른 주민등록번호 형식이 아닙니다.");
				//InValidJuminNumberException은 RuntimeException의 후손이 아니어서 예외처리 해야함
			}catch(InValidJuminNumberException e) {
				System.out.println("예외발생:"+e.getMessage());
			}
		}
			
		
	}
}
