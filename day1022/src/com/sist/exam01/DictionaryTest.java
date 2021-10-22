package com.sist.exam01;

import java.util.HashMap;
import java.util.Scanner;

public class DictionaryTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("tiger", "호랑이");
		map.put("lion", "사자");
		map.put("apple", "사과");
		
		Scanner sc = new Scanner(System.in);
		String eng,kor;
		
		while(true) {
			System.out.print("찾고자 하는 단어를 입력하세요==>");
			eng = sc.next();
			kor = map.get(eng);
			if(kor != null) {
				System.out.println(kor);
			}else{
				System.out.println("등록된 단어가 아닙니다.");
			}
		}
	}
}
