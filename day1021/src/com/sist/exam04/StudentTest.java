package com.sist.exam04;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		Scanner sc = new Scanner(System.in);
		String name,addr,phone;
		
		while(true) {
			System.out.print("1.�߰�, 2.�˻�, 3.����, 4.������, 5.��λ���, 0.����");
			int menu = sc.nextInt();
			
			if(menu == 0) {
				break;
			}
			
			switch(menu) {
				case 1:
					System.out.println("�л��� �̸��� �Է��ϼ���==>");
					name = sc.next();
					System.out.println("�л��� �ּҸ� �Է��ϼ���==>");
					addr = sc.next();
					System.out.println("�л��� ��ȭ��ȣ�� �Է��ϼ���==>");
					phone = sc.next();
					list.add(new Student(name, addr, phone));
					break;
				case 2:
					System.out.println("�˻��� �л��� �̸��� �Է��ϼ���==>");
					name = sc.next();
					Student searchStudent = null;
					for(int i=0; i<list.size();i++) {
						if(list.get(i).getName().equals(name)) {
							searchStudent = list.get(i);
							break;
						}
					}
					if(searchStudent != null) {
						System.out.println(searchStudent);
					}else {
						System.out.println("ã���� �ϴ� �л� "+name+"�� �����ϴ�.");
					}
					break;
				case 3:
					System.out.println("������ �л��� �̸��� �Է��ϼ���==>");
					name = sc.next();
					int i;
					int cnt = list.size(); 
					//����Ʈ�� �����ϸ� ����Ʈ�� ũ�Ⱑ ����ǹǷ� �����ϱ� ���� ����Ʈ�� ũ�⸦ �̸� ������ ����
					for(i=0; i<list.size();i++) {
						if(list.get(i).getName().equals(name)) {
							list.remove(i);
							break;
						}
					}
					if(i<cnt) {   
						System.out.println(name + "�л��� �����͸� �����Ͽ����ϴ�.");
					}else {
						System.out.println("�����Ϸ��� �л� "+ name + "��(��) �����ϴ�." );
					}
					break;
				case 4:
					//size�� 0���� �Ǻ� �Ǵ� isEmpty()
					if(list.isEmpty()) {
						System.out.println("�����Ͱ� �����ϴ�.");
					}else {
						for(Student student :list) {
							System.out.println(student);
						}
					}
					break;
				case 5:
					list.clear();
					System.out.println("�����͸� ��� �����Ͽ����ϴ�.");
					//break; ��������
			}
		}
	}
}
