package com.sist.exam01;

import java.util.ArrayList;
import java.util.Iterator;

public class Exercise07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> list = new ArrayList<Double>();
		
		list.add(3.5); //auto Boxing
		list.add(2.7);
		list.add(5.2);
		
		
		//인덱스 변수를 사용하는 for루프
		for(int i = 0; i<list.size(); i++) {
			//Double data = list.get(i);
			//double n =  data.doubleValue();
			double n = list.get(i);//auto UnBoxing
			System.out.println(n);
		}
		
		System.out.println("==========================");
		
		//for-each 구문
		for(double n : list) {
			System.out.println(n);
		}
		
		System.out.println("==========================");

		//Iterator 사용
		Iterator<Double> iter = list.iterator();
		while(iter.hasNext()) {
			double n = iter.next();
			System.out.println(n);
		}
		
	
	}

}
