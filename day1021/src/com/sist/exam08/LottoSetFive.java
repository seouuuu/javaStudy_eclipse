package com.sist.exam08;

import java.util.Random;
import java.util.TreeSet;


public class LottoSetFive {

	public static void main(String[] args) {
		
		for(int i=1;i<=5;i++) {      //5�� �ݺ� �ݺ���
			TreeSet<Integer> set = new TreeSet<Integer>();
			Random r = new Random();                 
			
			while(set.size()<6) {          //6��
				set.add(r.nextInt(45)+1);  //1~45
			}
			
			System.out.println(set);
		}	
	}
}
