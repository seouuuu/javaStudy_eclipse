package com.sist.exam04;

public class StringTestLastIndexOf {

	public static void main(String[] args) {
		String url = new String("https://docs.oracle.com/javase/8/docs/api/index.html");
		//�ǳ��� �ִ� "/"�� �ε��� ã��
		int index = url.lastIndexOf("/");
		System.out.println(index);
	}
}
