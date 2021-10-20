package com.sist.exam06;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapExam {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("abcd", "1234");
		map.put("cdef", "0000");
		map.put("cdef", "1234"); 
		//키는 중복되지 않기때문에 새로운 값이 기존 값을 덮어씀
		//값은 중복 가능하기 때문에 키값이 다른 abcd와 cdef의 값은 같아도됨 
		
		Scanner sc = new Scanner(System.in);
		System.out.print("id를 입력하세요==>");
		String user_id = sc.next();
		System.out.print("비밀번호를 입력하세요==>");
		String user_pwd = sc.next();
		
		if(!map.containsKey(user_id))                //키 존재 판별
			System.out.println("입력하신 id는 존재하지 않습니다.");
		
		if(!map.get(user_id).equals(user_pwd))       //키와 쌍인 값 판별
			System.out.println("비밀번호가 일치하지 않습니다.");
		else
			System.out.println("id와 비밀번호가 일치합니다.");
	}

}
