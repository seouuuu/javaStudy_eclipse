package com.sist.exam04;

public class StringBufferReplace {

	public static void main(String[] args) {
		StringBuffer data = new StringBuffer("hello korea");
		// "hello"를 "hi"로 변경
		//data.replace(0,5,"hi");
		//System.out.println(data);
		
		String oldString = "hello";
		String newString = "hi";
		
		//data로부터 oldString의 위치를 알아내기
		int start = data.indexOf(oldString);
		
		int end = start + oldString.length();
		
		data.replace(start,end,newString);
		System.out.println(data);
	}
}
