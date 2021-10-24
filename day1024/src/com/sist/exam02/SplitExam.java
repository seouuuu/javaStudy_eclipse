package com.sist.exam02;

public class SplitExam {

	public static void main(String[] args) {
		
		String data = "홍길동과이순신과강감찬과세종대왕";
		
		String []arr = data.split("과");
		
		for(int i=0;i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
