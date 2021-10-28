package com.sist.exam02;

import java.io.FileWriter;

public class StudentTest {

	public static void main(String[] args) {
		
		Student hong = new Student("홍길동",100,100,100);
		
		//Student 객체인 hong의 정보를 파일로 기록
		//문자단위 - 이름,국어,영어,수학을 모두 문자열로 만들어 차례로 출력
		//바이트단위 - 객체를 통째로 출력

		
		try {
		//문자단위
			FileWriter fw = new FileWriter("c:/myData/hong.text");
			
			//객체의 이름을 파일로 출력
			fw.write(hong.getName()+",");
			
			//객체의 국어점수를 파일로 출력
			fw.write(hong.getKor()+",");
			
			//객체의 영어점수를 파일로 출력
			fw.write(hong.getEng()+",");
			
			//객체의 수학점수를 파일로 출력
			fw.write(hong.getMath()+"");  //문자열 만들기
			
			//파일의 사용 완료후 파일 닫기
			fw.close();
			
			System.out.println("파일생성");
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

}
