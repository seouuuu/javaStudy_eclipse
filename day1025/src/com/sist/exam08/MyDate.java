package com.sist.exam08;

import java.util.StringTokenizer;

public class MyDate  {
	public  MyDate (String str) throws IllegalArgumentException {
		if(str == null) {
			throw new IllegalArgumentException("잘못된 입력값입니다.");
		}
		
		StringTokenizer st = new StringTokenizer(str,"/");
		String year = st.nextToken();
		String month = st.nextToken();
		String date = st.nextToken();
		
		System.out.printf("%s년 %s월 %s일",year,month,date);
		
		
	}
}
