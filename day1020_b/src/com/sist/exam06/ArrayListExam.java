package com.sist.exam06;

import java.util.ArrayList;  //List - ArrayList
import java.util.Collections;

public class ArrayListExam {

	public static void main(String[] args) {
		ArrayList list = new ArrayList(4);   //ũ�Ⱑ 3�� ArrayList ����
		list.add(new Integer(3));
		list.add(new Integer(2));
		list.add(new Integer(1));
		System.out.println(list);
	
		ArrayList list2 = new ArrayList(5);   //ũ�Ⱑ 5�� ArrayList ����
		list2.add(new Integer(4));
		list2.add(new Integer(0));
		list2.add(new Integer(3));
		list2.add(new Integer(7));
		list2.add(new Integer(2));
		System.out.println(list2);
		
		Collections.sort(list);
		Collections.sort(list2);   //list�� list1 ����
		System.out.println(list);
		System.out.println(list2);
		
	}

}
