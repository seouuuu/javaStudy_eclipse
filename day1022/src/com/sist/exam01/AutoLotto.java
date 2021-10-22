package com.sist.exam01;

import java.util.Random;
import java.util.TreeSet;

public class AutoLotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeSet<Integer> lotto = new TreeSet<Integer>();
		Random r = new Random();
		
		while(lotto.size()<6) {
			lotto.add(r.nextInt(45)+1);	
		}
		System.out.println(lotto);

	}
}
