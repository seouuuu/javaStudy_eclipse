package com.sist.exam03;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.SortingFocusTraversalPolicy;

public class ArrayListScoreTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int tot = 0;
		
		for(int i=0; i<5;i++) {
			System.out.printf("%d��° �л��� ������ �Է��ϼ���==>",i+1);
			list.add(sc.nextInt());
			tot += list.get(i);
		}
		
		double avg = (double)tot/list.size();
		
		for(int i=0; i<list.size(); i++) {
			System.out.printf("%d�� �л��� ����==>%d\n",i+1,list.get(i));
		}
		System.out.println();
		System.out.println("����:"+tot);
		System.out.printf("���:%.1f",avg);
		
	}

}
