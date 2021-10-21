package com.sist.exam08;

import java.util.Scanner;

public class WordFrequencyExam {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문장을 입력하세요==>");
		String data = sc.nextLine();   //공백 포함 문장 입력
		
		//hello 개수
		int sum=0;
		int index_hello = -5;  //5글자
		
		while(index_hello < data.length()) {     
			index_hello = data.indexOf("hello",index_hello +5);
			if(index_hello != -1) {   //index가 -1이 아니면 같은 문자열이 존재하므로 sum++
				sum++;
			}else
				break;                //같은 문자열이 없으면 빠져나오기
		}
		System.out.println("hello:"+sum);
		
		//korea 개수
		int sum2=0;
		int index_korea = -5;  //5글자
		
		while(index_korea < data.length()) {     
			index_korea = data.indexOf("korea",index_korea +5);
			if(index_korea != -1) {
				sum2++;
			}else
				break;
		}
		System.out.println("korea:"+sum2);
		
		//java 개수
		int sum3=0;
		int index_java = -4;  //4글자
		
		while(index_java < data.length()) {     
			index_java = data.indexOf("java",index_java +4);
			if(index_java != -1) {
				sum3++;
			}else
				break;
		}
		System.out.println("java:"+sum3);
	}
}
