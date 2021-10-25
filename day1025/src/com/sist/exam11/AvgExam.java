package com.sist.exam11;

import java.util.Scanner;

public class AvgExam {
	public static double getAverage(int []arr) {
		double avg;
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum +=arr[i];
		}
		avg = (double)sum/arr.length;
		
		return avg;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int []arr = new int [10];
		try {
			for(int i=0;i<arr.length;i++) {
				System.out.printf("%d번째 정수를 입력하세요==>",i+1);
				arr[i] = sc.nextInt();
			}
			
			System.out.println("평균: "+ getAverage(arr));
		}catch(ArithmeticException a) {
			System.out.println("");
		}catch(NegativeArraySizeException n) {
			System.out.println("");
		}catch(ArrayIndexOutOfBoundsException ar) {
			System.out.println("");
		}catch(NullPointerException np) {
			System.out.println("");
		}
	}

}
