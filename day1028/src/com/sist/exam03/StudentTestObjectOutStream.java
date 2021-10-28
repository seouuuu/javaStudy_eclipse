package com.sist.exam03;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;

public class StudentTestObjectOutStream {

	public static void main(String[] args) {
		
		Student hong = new Student("홍길동",100,100,100);
		
		//Student 객체인 hong의 정보를 파일로 기록
		//문자단위 - 이름,국어,영어,수학을 모두 문자열로 만들어 차례로 출력
		//바이트단위 - 객체를 통째로 출력

		//바이트단위(객체단위)로 출력
		try {
			//객체단위로 출력하기 위한 ObjectOutputStream 생성
			//이때 확장자는 텍스트파일이 아니므로 .txt로 안함
			//프로그램의 성격에 맞도록 설정
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/myData/hong.stu"));
			
			//객체를 출력
			oos.writeObject(hong);
			
			//파일 사용 완료후 닫기
			oos.close();
			
			System.out.println("파일이 생성되었습니다.");
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

}

