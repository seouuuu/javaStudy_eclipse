package com.sist.exam03;
//exercise7 - 1. �ε��� ������ ����ϴ� for ����
import java.util.ArrayList;

public class ArrayListForExam {

	public static void main(String[] args) {
		
		ArrayList<Double> list = new ArrayList<Double>();
		
		list.add(2.5);
		list.add(5.0);   //list.add(5) ����
		list.add(10.2);
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
}
