package com.sist.exam06;

import java.util.HashSet; //Set - HashSet
import java.util.Set;

public class HashSetExam {

	public static void main(String[] args) {
		Object []arr = {"1",new Integer(1), "2","2","3","4","4","4"};
		//첫번째 1은 String, 두번째 1은 Integer - 서로 다르기 때문에 중복 아님
		Set set = new HashSet();
		
		for(int i=0 ; i<arr.length ; i++) {
			set.add(arr[i]);       //HashSet에 arr요소 저장
		}
		System.out.println(set);   //HashSet에 저장된 요소 출력
	}
}
