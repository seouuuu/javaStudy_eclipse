package com.sist.exam04;

public class StringTestIndexOf {

	public static void main(String[] args) {
		String data = new String("Returns the index within this string of the first occurrence of");
		int index = data.indexOf("the");
		System.out.println(index); //8
		
		int index2 = data.indexOf("the",9); //9번째 이후에서 찾기.40
		System.out.println(index2);
		
		int index3 = data.indexOf("hello"); //-1
		System.out.println(index3);
		
		int index4 = data.indexOf('e'); //1
		System.out.println(index4);
		
		int index5 = data.indexOf("e"); //1
		System.out.println(index5);
	}
}
