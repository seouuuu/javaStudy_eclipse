package com.sist.exam02;

import java.util.StringTokenizer;

public class StringTokenizerExam {

	public static void main(String[] args) {

		String data = "ȫ�浿�����������̼��Ű��������";
		StringTokenizer st = new StringTokenizer(data,"��");
		
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			System.out.println(s);
		}

	}

}
