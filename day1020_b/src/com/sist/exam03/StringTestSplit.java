package com.sist.exam03;

import java.util.StringTokenizer;

public class StringTestSplit {

	public static void main(String[] args) {
		String data = "홍길동/20/서울/010-1234-5678";
		String []arr = data.split("/");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
		
		System.out.println("---------------------------");
		
		StringTokenizer st = new StringTokenizer(data,"/");
		while(st.hasMoreTokens()) { // "/"가지고 있는 동안 실행
			String str = st.nextToken();
			System.out.println(str);
		}
	}
}
