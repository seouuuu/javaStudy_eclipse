package com.sist.exam08;

import java.util.StringTokenizer;

public class MyDate  {
	public  MyDate (String str) throws IllegalArgumentException {
		if(str == null) {
			throw new IllegalArgumentException("�߸��� �Է°��Դϴ�.");
		}
		
		StringTokenizer st = new StringTokenizer(str,"/");
		String year = st.nextToken();
		String month = st.nextToken();
		String date = st.nextToken();
		
		System.out.printf("%s�� %s�� %s��",year,month,date);
		
		
	}
}
