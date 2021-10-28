package com.sist.exam01;

import java.io.FileReader;

public class StudentTest {

	public static void main(String[] args) {
			
		//텍스트파일의 내용을 컴퓨터 메모리로 읽어들이기 위해 FileReader클래스 이용
		//FileReader의 생성자는 "예외"를  가지고 있음
		try {
			FileReader fr = new FileReader("c:/myData/student.txt");
			//파일로부터 한글자씩 읽어들이는 메소드 : read(), 읽어들인 문자의 정수값 반환
			//파일의 끝에 도달하면 -1 반환
			
			//읽어들인 문자들을 모아 문자열을 만들기 위한 변수
			//한문자씩 읽어들여 누적하기 위해 초기값 ""설정
			String str = "";
			
			int ch;		//파일로 부터 한글자씩 읽어들이기 위한 변수
			while( true ) {
				ch = fr.read();	//파일로부터 한글자씩 읽어들임
				if(ch == -1) {	//파일의 끝에 도달하면 반복문탈출
					break;
				}
				//읽어들인 문자의 정수값을 문자로 형변환
				char data = (char)ch;
				//System.out.print(data);	
				
				//읽어들인 문자를 문자열 변수 str에 누적
				str += data;
			}//파일의 내용을 모두 읽으면 반복문 탈출
			
			//파일 사용 완료후 파일 닫기
			fr.close();
			
			System.out.println(str);
			
			//","로 문자열 분리 - split/StringTokenizer
			String []arr = str.split(",");
			String name = arr[0];	
			int kor = Integer.parseInt(arr[1]);		
			int eng = Integer.parseInt(arr[2]);
			int math = Integer.parseInt(arr[3]);
			
			int tot = kor + eng + math;
			int avg = tot/3;
			
			System.out.println("이름:"+ name);
			System.out.println("국어:"+ kor);
			System.out.println("영어:"+ eng);
			System.out.println("수학:"+ math);
			System.out.println("총점:"+ tot);
			System.out.println("평균:"+ avg);
			
		}catch (Exception e) {
			//예외가 발생되면 예외메세지 출력
			System.out.println("예외발생: " + e.getMessage());
		}
	}
}
