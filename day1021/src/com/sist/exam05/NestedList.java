package com.sist.exam05;

import java.util.ArrayList;

public class NestedList {

	public static void main(String[] args) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> row1 = new ArrayList<String>();
		row1.add("ȫ�浿");
		row1.add("����");
		row1.add("010-1234-5678");
		
		ArrayList<String> row2 = new ArrayList<String>();
		row2.add("������");
		row2.add("��õ");
		row2.add("010-1234-2222");
		
		ArrayList<String> row3 = new ArrayList<String>();
		row3.add("������");
		row3.add("����");
		row3.add("010-1234-3333");
		
		list.add(row1);
		list.add(row2);
		list.add(row3);
		
		// list�� ��� ������ ���
		/*
		for(ArrayList<String> row:list) {
			System.out.println(row);
			}
		*/
		
		// list�� ��ҵ鵵 ��� ������ ���
		System.out.println("�̸�\t�ּ�\t��ȭ");
		for(ArrayList<String> row:list) {
			for(String data:row) {
				System.out.print(data+"\t"); 
			}
			System.out.println();
		}
	}
}
