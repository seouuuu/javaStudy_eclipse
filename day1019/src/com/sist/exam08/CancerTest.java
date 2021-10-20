package com.sist.exam08;

import java.util.Scanner;
import java.util.Date;
public class CancerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Date today = new Date();
		int thisYear = today.getYear() +1900;
		String name,num;
		
		System.out.print("이름을 입력하세요==>");
		name = sc.next();
		
		System.out.print("주민등록번호를 입력하세요xxxxxx-xxxxxxx==>");
		num = sc.next();
		
		int age = (num.charAt(0)-48)*10 + (num.charAt(1)-48);
		
		if(age>=21) {
			age = thisYear-(age+1900)+1;
		}
		
		if(age>=40 && thisYear%2 == age%2 && num.charAt(7) =='1' ) {
			if(age>=50) {
				System.out.printf("%d님은 %s년도 무료암검진 대상자이며 검진항목은 위암,간암,대장암입니다.",name,thisYear);
			}
			else
				System.out.printf("%d님은 %s년도 무료암검진 대상자이며 검진항목은 위암,간암입니다.",name,thisYear);
		}else if(age>=40 && thisYear%2 == age%2 && num.charAt(7) =='2') {
			if(age>=50) {
				System.out.printf("%d님은 %s년도 무료암검진 대상자이며 검진항목은 위암,간암,대장암,유방암,자궁암입니다.",name,thisYear);
			}
			else
				System.out.printf("%d님은 %s년도 무료암검진 대상자이며 검진항목은 위암,간암,유방암,자궁암입니다.",name,thisYear);
		}
		else
			System.out.printf("%s님은 %d년도 무료암검진 대상자가 아닙니다.",name,thisYear);
		
	}
}
