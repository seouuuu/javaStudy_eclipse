package com.sist.exam08;

import java.util.Scanner;

public class WordFrequencyExam {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �Է��ϼ���==>");
		String data = sc.nextLine();   //���� ���� ���� �Է�
		
		//hello ����
		int sum=0;
		int index_hello = -5;  //5����
		
		while(index_hello < data.length()) {     
			index_hello = data.indexOf("hello",index_hello +5);
			if(index_hello != -1) {   //index�� -1�� �ƴϸ� ���� ���ڿ��� �����ϹǷ� sum++
				sum++;
			}else
				break;                //���� ���ڿ��� ������ ����������
		}
		System.out.println("hello:"+sum);
		
		//korea ����
		int sum2=0;
		int index_korea = -5;  //5����
		
		while(index_korea < data.length()) {     
			index_korea = data.indexOf("korea",index_korea +5);
			if(index_korea != -1) {
				sum2++;
			}else
				break;
		}
		System.out.println("korea:"+sum2);
		
		//java ����
		int sum3=0;
		int index_java = -4;  //4����
		
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
