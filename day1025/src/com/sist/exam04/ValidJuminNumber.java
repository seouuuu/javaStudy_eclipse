package com.sist.exam04;

import java.util.Scanner;

public class ValidJuminNumber {

	public static void main(String[] args) {
		String jumin;
		Scanner sc = new Scanner(System.in);
		System.out.println("�ֹι�ȣ�� �Է��ϼ���xxxxxx-xxxxxxx==>");
		jumin = sc.next();
		
		int []n = {2,3,4,5,6,7,0,8,9,2,3,4,5};
		//�ε��� 6��°�� ��� ����x
		//���ڿ��� ���̴� 14��
		//�ݺ������ؾ��� �ε����� 12   i<jumin.length()-1
		
		int sum = 0;
		for(int i=0; i<jumin.length()-1;i++) {
			if(i != 6) {
				sum = sum+Integer.parseInt(jumin.charAt(i)+"")*n[i];
				//charAt()�� ����� char
				//char�� ���ڿ�(String)���� ����� ���� +""
			}
		}
		sum = sum % 11;
		sum = 11 - sum;
		if(sum == 10) {
			sum = 0;
		}
		if(sum == 11) {
			sum = 1;
		}
		
		int check = Integer.parseInt(jumin.charAt(13)+"");
		
		if(sum == check) {
			System.out.println("�ùٸ� �ֹε�Ϲ�ȣ�Դϴ�.");
		}else {
			try {
				throw new InValidJuminNumberException("�ùٸ� �ֹε�Ϲ�ȣ ������ �ƴմϴ�.");
				//InValidJuminNumberException�� RuntimeException�� �ļ��� �ƴϾ ����ó�� �ؾ���
			}catch(InValidJuminNumberException e) {
				System.out.println("���ܹ߻�:"+e.getMessage());
			}
		}
			
		
	}
}
