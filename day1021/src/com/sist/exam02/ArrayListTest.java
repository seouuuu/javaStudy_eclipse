package com.sist.exam02;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add("���");
		list.add("����");
		list.add("����");
		System.out.println(list);
		list.add("����");
		list.add("���");
		System.out.println(list);
	}
}
