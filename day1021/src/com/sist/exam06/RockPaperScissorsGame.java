package com.sist.exam06;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

	public static void main(String[] args) {
		
		//��ǻ�Ϳ� ����ڰ� ����/����/���ϴ� ���α׷�
		//��ǻ�Ͱ� ����/����/���� �ϳ� �ڵ�(����̱�)
		//����ڿ��� ����/����/�� �� �ϳ� �Է¹ޱ�
		
		//0:����, 1:����, 2:��
		
		Scanner sc = new Scanner(System.in);
		
		HashMap<Integer, String> map =new HashMap<Integer, String>();
		map.put(0, "����");
		map.put(1, "����");
		map.put(2, "��");
		
		Random r = new Random();
		int com = r.nextInt(3);
		
		System.out.println("0:����, 1:����, 2:��");
		System.out.println("�����ϼ���==>");
		int user = sc.nextInt();
		
		
		System.out.println("��ǻ�ʹ� "+map.get(com)+"�� �������ϴ�.");
		System.out.println("����ڴ� "+map.get(user)+"�� �������ϴ�.");
		
		if(com == user) {			//���� ���
			System.out.println("��ǻ�Ϳ� ����ڴ� �����ϴ�.");
		} 
		//����ڰ� �̱�� ���
		else if(user==0 && com==2|| user ==1 && com == 0|| user==2 && com==1){
			System.out.println("����ڰ� �̰���ϴ�.");
		} else {					//����ڰ� ���� ���
			System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
		}
		
		/*
		if(com ==0 && user ==2) {
			System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
		}else if (com==2 && user ==0) {
			System.out.println("����ڰ� �̰���ϴ�.");
		}else if(com>user) {
			System.out.println("��ǻ�Ͱ� �̰���ϴ�.");
		} else {
			System.out.println("����ڰ� �̰���ϴ�.");
		}
		*/
	}
}
