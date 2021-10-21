package com.sist.exam03;

import java.util.ArrayList;

public class ArrayListExam {

	public static void main(String[] args) {
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(100);
		list.add(70);
		list.add(80);
		list.add(90);
		list.add(85);
		
		System.out.println(list);
		
		int tot = 0;
		
		for(int i=0;i<list.size();i++) {
			tot += list.get(i);
		}
		double avg = tot/5.0;
		
		System.out.println("ÃÑÁ¡:"+tot);
		System.out.println("Æò±Õ:"+avg);
		

	}

}
