package com.sist.exam08;

import java.util.Scanner;
import java.util.Date;
public class CancerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Date today = new Date();
		int thisYear = today.getYear() +1900;
		String name,num;
		
		System.out.print("�̸��� �Է��ϼ���==>");
		name = sc.next();
		
		System.out.print("�ֹε�Ϲ�ȣ�� �Է��ϼ���xxxxxx-xxxxxxx==>");
		num = sc.next();
		
		int age = (num.charAt(0)-48)*10 + (num.charAt(1)-48);
		
		if(age>=21) {
			age = thisYear-(age+1900)+1;
		}
		
		if(age>=40 && thisYear%2 == age%2 && num.charAt(7) =='1' ) {
			if(age>=50) {
				System.out.printf("%d���� %s�⵵ ����ϰ��� ������̸� �����׸��� ����,����,������Դϴ�.",name,thisYear);
			}
			else
				System.out.printf("%d���� %s�⵵ ����ϰ��� ������̸� �����׸��� ����,�����Դϴ�.",name,thisYear);
		}else if(age>=40 && thisYear%2 == age%2 && num.charAt(7) =='2') {
			if(age>=50) {
				System.out.printf("%d���� %s�⵵ ����ϰ��� ������̸� �����׸��� ����,����,�����,�����,�ڱþ��Դϴ�.",name,thisYear);
			}
			else
				System.out.printf("%d���� %s�⵵ ����ϰ��� ������̸� �����׸��� ����,����,�����,�ڱþ��Դϴ�.",name,thisYear);
		}
		else
			System.out.printf("%s���� %d�⵵ ����ϰ��� ����ڰ� �ƴմϴ�.",name,thisYear);
		
	}
}
