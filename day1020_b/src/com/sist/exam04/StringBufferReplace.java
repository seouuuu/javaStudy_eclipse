package com.sist.exam04;

public class StringBufferReplace {

	public static void main(String[] args) {
		StringBuffer data = new StringBuffer("hello korea");
		// "hello"�� "hi"�� ����
		//data.replace(0,5,"hi");
		//System.out.println(data);
		
		String oldString = "hello";
		String newString = "hi";
		
		//data�κ��� oldString�� ��ġ�� �˾Ƴ���
		int start = data.indexOf(oldString);
		
		int end = start + oldString.length();
		
		data.replace(start,end,newString);
		System.out.println(data);
	}
}
