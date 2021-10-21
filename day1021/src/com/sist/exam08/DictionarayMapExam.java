package com.sist.exam08;

import java.util.HashMap;
import java.util.Scanner;

public class DictionarayMapExam {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("배열","동일한 성격의 데이터를 관리하기 쉽도록 하나로 묶는 일");
		map.put("변수","어떤 관계나 범위 안에서 여러 가지 값으로 변할 수 있는 수");
		map.put("난수", "특정한 배열 순서나 규칙을 가지지 않는, 연속적인 임의의 수");
		map.put("속성", "사물의 특징이나 성질");
		
		
		
		String word;
		String meaning;
		
		while(true) {
			System.out.print("1.단어검색 2.추가 3.삭제 4.모두출력 0.종료");
			int num = sc.nextInt();
			if(num == 0) {     //종료
				break;
			}   
				
			switch(num) {
				case 1: 
					System.out.print("단어를 입력하세요==>");
					String data = sc.next();
					if (map.get(data) !=null) {
						System.out.printf("%s : %s\n",data,map.get(data));
					}else
						System.out.println("찾는 단어가 없습니다.");
					break;
				case 2:
					System.out.print("추가할 단어를 입력하세요==>");
					word = sc.next();
					System.out.print("단어의 뜻을 입력하세요==>");
					meaning = sc.next();
					map.put(word, meaning);
					break;
				case 3:
					System.out.print("삭제할 단어를 입력하세요==>");
					word = sc.next();
					map.remove(word);
					break;
				case 4:
					if(map.isEmpty()) {
						System.out.println("데이터가 없습니다.");
					}else
						System.out.println(map);
			}	
		}
	}
}
