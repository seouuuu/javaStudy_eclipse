package com.sist.exam07;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreExam {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Double> list = new ArrayList<Double>();
		
		for(int i=0;i<10;i++) {
				System.out.printf("%d��° �ɻ������� ������ �Է��ϼ���==>",i+1);
				list.add(sc.nextDouble());
			}
	
		
		double max = list.get(0);
 		for(int i=1;i<list.size();i++) {
			if(list.get(i)>max){
				max = list.get(i);
			}
		}
 		
 		double min = list.get(0);
 		for(int i=1;i<list.size();i++) {
			if(list.get(i)<min){
				min = list.get(i);
			}
		}
 		
 		list.remove(max);
 		list.remove(min);
 		
 		double tot = 0;
 		for(int i=0;i<list.size();i++) {
 			tot += list.get(i);
 		}
 		
 		for (Double d : list) {
 			System.out.println(d);
 		}
 		
 		System.out.println("�ְ���,�������� ������ �ɻ����� ���� ����:"+tot);
	}
}

