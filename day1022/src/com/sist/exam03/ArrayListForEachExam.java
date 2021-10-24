package com.sist.exam03;
//exercise7 - 2. for-each  ±¸¹®
import java.util.ArrayList;

public class ArrayListForEachExam {

	public static void main(String[] args) {
		
		ArrayList<Double> list = new ArrayList<Double>();
		
		list.add(3.2);
		list.add(7.1);
		list.add(-3.1);
		
		for(Double d:list) {
			System.out.println(d);
		}
	}
}
