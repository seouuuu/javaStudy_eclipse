package com.sist.exam06;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapExam {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("abcd", "1234");
		map.put("cdef", "0000");
		map.put("cdef", "1234"); 
		//Ű�� �ߺ����� �ʱ⶧���� ���ο� ���� ���� ���� ���
		//���� �ߺ� �����ϱ� ������ Ű���� �ٸ� abcd�� cdef�� ���� ���Ƶ��� 
		
		Scanner sc = new Scanner(System.in);
		System.out.print("id�� �Է��ϼ���==>");
		String user_id = sc.next();
		System.out.print("��й�ȣ�� �Է��ϼ���==>");
		String user_pwd = sc.next();
		
		if(!map.containsKey(user_id))                //Ű ���� �Ǻ�
			System.out.println("�Է��Ͻ� id�� �������� �ʽ��ϴ�.");
		
		if(!map.get(user_id).equals(user_pwd))       //Ű�� ���� �� �Ǻ�
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		else
			System.out.println("id�� ��й�ȣ�� ��ġ�մϴ�.");
	}

}
