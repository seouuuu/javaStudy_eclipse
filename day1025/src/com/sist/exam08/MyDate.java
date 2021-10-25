package com.sist.exam08;

import java.util.StringTokenizer;

public class MyDate  {
	public void mydate(String str) throws IllegalArgumentException {
		StringTokenizer st = new StringTokenizer(str,"/");
		String year = st.nextToken();
		String month = st.nextToken();
		String date = st.nextToken();
		
		System.out.printf("%s년 %s월 %s일",year,month,date);
		
		if(str == null) {
			throw new IllegalArgumentException("잘못된 입력값입니다.");
		}
	}
}
