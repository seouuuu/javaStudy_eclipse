package com.sist.exam03;
//exercise7 - 3. Iterator
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListIteratorExam {

	public static void main(String[] args) {
		
		ArrayList<Double> list = new ArrayList<Double>();
		
		list.add(2.12);
		list.add(0.2);
		list.add(-4.1);
		
		Iterator<Double> iter = list.iterator();
		while(iter.hasNext()) {
			Double d = iter.next();
			System.out.println(d);
		}
	}
}
