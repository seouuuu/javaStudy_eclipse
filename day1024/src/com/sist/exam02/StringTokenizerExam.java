package com.sist.exam02;

import java.util.StringTokenizer;

public class StringTokenizerExam {

	public static void main(String[] args) {

		String data = "홍길동과강감찬과이순신과세종대왕";
		StringTokenizer st = new StringTokenizer(data,"과");
		
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			System.out.println(s);
		}

	}

}
