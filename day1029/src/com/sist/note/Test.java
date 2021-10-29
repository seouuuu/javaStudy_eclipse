package com.sist.note;

public class Test {

	public static void main(String[] args) {
		String data = "¸Þ¸ð.txt";
		//String []arr = data.split(".");
		//System.out.println(arr[0]);
		//System.out.println(arr[1]);
		
		String result = data.substring(0,data.indexOf("."));
		System.out.println(result);
	}

}
