package com.sist.exam02;

import java.util.Random;

public class AutoLottoUsingArray {
	public static void printArray(int []data) {
		for(int n:data) {
			System.out.print(n+"\t");
		}
	}

	public static boolean isAlready(int value,int last, int []arr) {   //중복 제거
		boolean flag = false;
		for(int i=0; i<=last; i++) {
			if(arr[i] == value) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	public static void sortArray(int []arr) {         //정렬
		for(int i=0; i<arr.length ; i++) {
			for (int j=i+1; j<arr.length ;j++) {
				if (arr[j]<arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int []n = new int[6];
		
		Random r = new Random();
		for(int i=0; i<6;) {
			//n[i] = r.nextInt();  //범위가 큰 난수
			//n[i] = r.nextInt(45)+1;   //1~45, 중복허용
			
			int temp = r.nextInt(45)+1;
			
			if(!isAlready(temp,i,n))  //isAlready(temp,i,n)==false 가능
			n[i] = temp;
			i++;
		}
		sortArray(n);
		printArray(n);
		
		
	}

}
