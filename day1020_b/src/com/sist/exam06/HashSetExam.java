package com.sist.exam06;

import java.util.HashSet; //Set - HashSet
import java.util.Set;

public class HashSetExam {

	public static void main(String[] args) {
		Object []arr = {"1",new Integer(1), "2","2","3","4","4","4"};
		//ù��° 1�� String, �ι�° 1�� Integer - ���� �ٸ��� ������ �ߺ� �ƴ�
		Set set = new HashSet();
		
		for(int i=0 ; i<arr.length ; i++) {
			set.add(arr[i]);       //HashSet�� arr��� ����
		}
		System.out.println(set);   //HashSet�� ����� ��� ���
	}
}
