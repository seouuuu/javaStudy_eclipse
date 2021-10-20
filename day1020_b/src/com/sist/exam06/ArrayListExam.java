package com.sist.exam06;

import java.util.ArrayList;  //List - ArrayList
import java.util.Collections;

public class ArrayListExam {

	public static void main(String[] args) {
		ArrayList list = new ArrayList(4);   //크기가 3인 ArrayList 생성
		list.add(new Integer(3));
		list.add(new Integer(2));
		list.add(new Integer(1));
		System.out.println(list);
	
		ArrayList list2 = new ArrayList(5);   //크기가 5인 ArrayList 생성
		list2.add(new Integer(4));
		list2.add(new Integer(0));
		list2.add(new Integer(3));
		list2.add(new Integer(7));
		list2.add(new Integer(2));
		System.out.println(list2);
		
		Collections.sort(list);
		Collections.sort(list2);   //list와 list1 정렬
		System.out.println(list);
		System.out.println(list2);
		
	}

}
