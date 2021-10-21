package com.sist.exam03;

import java.util.ArrayList;
import java.util.Date;

public class ArrayListGeneric {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(100);
		list.add("홍길동");
		list.add(26.7);
		list.add(new Date());
		list.add(true);
		System.out.println(list);
		
		
		ArrayList<String> list2 = new ArrayList<String>();
		//list2.add(100);  오류
		list2.add("홍길동");
		list2.add("유관순");
		list2.add("이순신");
		System.out.println(list2);
		
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add(100+"");
		list3.add("홍길동");
		list3.add(26.7+"");
		list3.add(new Date()+"");
		list3.add(true+"");
		System.out.println(list);
		
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		list4.add(50);
		list4.add(60);
		list4.add(70);
		list4.add(80);
		//list4.add(85.8);
		System.out.println(list4);
	}

}
