package com.sist.exam02;

public class SplitExam {

	public static void main(String[] args) {
		
		String data = "ȫ�浿���̼��Ű����������������";
		
		String []arr = data.split("��");
		
		for(int i=0;i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
