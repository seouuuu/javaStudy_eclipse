package com.sist.exam02;

import java.util.HashSet;

public class HashSetTest {

	public static void main(String[] args) {
		
		HashSet data = new HashSet();
		data.add("���");
		data.add("����");
		data.add("����");
		data.add("��");
		System.out.println(data);
		data.add("������");
		data.add("���");
		System.out.println(data);

	}
}
