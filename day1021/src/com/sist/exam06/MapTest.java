package com.sist.exam06;

import java.util.ArrayList;
import java.util.HashMap;

public class MapTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("ȫ�浿");
		list.add("����");
		list.add("010-1234-5678");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("�̸�","ȫ�浿");
		map.put("�ּ�","����");
		map.put("��ȭ","010-1234-1111");
		
		//list���� �ּ� ���. index �̿�
		System.out.println(list.get(1));
		//map���� �ּ� ���. "�ּ�"��� Ű �̿�
		System.out.println(map.get("�ּ�"));
	}

}
