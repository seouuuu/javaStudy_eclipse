package com.sist.exam03;

public class StringTestValueOf {
	public static void pro(String str) {
		System.out.println(str);
	} // String�� �Ű������� ������ �޼ҵ�

	public static void main(String[] args) {
		int data = 2021;
		//pro(data); data�� �������̱� ������ pro ȣ��� String���� ��ȯ�ؾ��� 
		pro(String.valueOf(data));
		pro(data+"");
	}
}
