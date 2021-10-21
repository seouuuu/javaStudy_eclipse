package com.sist.exam08;

import java.util.HashMap;
import java.util.Scanner;

public class DictionarayMapExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("�迭","������ ������ �����͸� �����ϱ� ������ �ϳ��� ���� ��");
		map.put("����","� ���質 ���� �ȿ��� ���� ���� ������ ���� �� �ִ� ��");
		map.put("����", "Ư���� �迭 ������ ��Ģ�� ������ �ʴ�, �������� ������ ��");
		map.put("�Ӽ�", "�繰�� Ư¡�̳� ����");
		
		
		
		String word;
		String meaning;
		
		while(true) {
			System.out.print("1.�ܾ�˻� 2.�߰� 3.���� 4.������ 0.����");
			int num = sc.nextInt();
			if(num == 0) {     //����
				break;
			}   
				
			switch(num) {
				case 1: 
					System.out.print("�ܾ �Է��ϼ���==>");
					String data = sc.next();
					if (map.get(data) !=null) {
						System.out.printf("%s : %s\n",data,map.get(data));
					}else
						System.out.println("ã�� �ܾ �����ϴ�.");
					break;
				case 2:
					System.out.print("�߰��� �ܾ �Է��ϼ���==>");
					word = sc.next();
					System.out.print("�ܾ��� ���� �Է��ϼ���==>");
					meaning = sc.next();
					map.put(word, meaning);
					break;
				case 3:
					System.out.print("������ �ܾ �Է��ϼ���==>");
					word = sc.next();
					map.remove(word);
					break;
				case 4:
					if(map.isEmpty()) {
						System.out.println("�����Ͱ� �����ϴ�.");
					}else
						System.out.println(map);
			}	
		}
	}
}
