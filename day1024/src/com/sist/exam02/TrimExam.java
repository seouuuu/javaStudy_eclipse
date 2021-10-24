package com.sist.exam02;

public class TrimExam {

	public static void main(String[] args) {
		String data = "  hello  ";
		int n = data.length();
		System.out.println(n);
		String data2 = data.trim();
		System.out.println(data2);
		System.out.println(data2.length());

	}

}
