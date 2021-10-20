package com.sist.exam09;

import java.util.Scanner;

//ㄱㄴㄷㄹㅁㅂ - ㅅㅇㅈㅊㅋㅌㅍ
//ㅍ = 11-{(2×ㄱ+3×ㄴ+4×ㄷ+5×ㄹ+6×ㅁ+7×ㅂ+8×ㅅ+9×ㅇ+2×ㅈ+3×ㅊ+4×ㅋ+5×ㅌ) mod 11}
//소괄호 안에 있는 것을 계산한 값을 11로 나눠서 나온 나머지를 11에서 뺀 값이 ㅍ이다. 

public class ResidentNumberExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요xxxxxx-xxxxxxx==>");
		String num = sc.next();
		
		int data;
		data = 11-((2*(num.charAt(0)-48)
				+ 3*(num.charAt(1)-48)
				+ 4*(num.charAt(2)-48)
				+ 5*(num.charAt(3)-48)
				+ 6*(num.charAt(4)-48)
				+ 7*(num.charAt(5)-48) //num.charAt(6)은 제외
				+ 8*(num.charAt(7)-48)
				+ 9*(num.charAt(8)-48)
				+ 2*(num.charAt(9)-48)
				+ 3*(num.charAt(10)-48)
				+ 4*(num.charAt(11)-48)
				+ 5*(num.charAt(12)-48)) % 11);
		if(data == num.charAt(13)-48) {
			System.out.println("올바른 주민등록번호입니다.");
		}
		else
			System.out.println("올바르지 않은 주민등록번호입니다.");	
	}
}
