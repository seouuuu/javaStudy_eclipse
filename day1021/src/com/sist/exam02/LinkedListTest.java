package com.sist.exam02;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
	
		LinkedList list = new LinkedList();
		
		list.add("���");
		list.add("����");
		list.add("����");
		System.out.println(list);
		list.add("����");
		list.add("���");
		System.out.println(list);
	}

}
