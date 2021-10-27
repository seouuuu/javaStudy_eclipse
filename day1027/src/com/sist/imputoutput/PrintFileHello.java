package com.sist.imputoutput;

import java.io.FileWriter;

public class PrintFileHello {

	public static void main(String[] args) {
		//이름과 나이를 파일로 기록
		//문자단위의 출력을 위한 writer의 후손 중 파일로 출력을 위한 FileWriter를 생성
		try {	//RuntimeException에 없으므로 try-catch문 작성
			FileWriter fw = new FileWriter("c:/myData/hello.txt");
			fw.write("이름은 홍길동이고\n");
			fw.write("나이는 20살입니다.");
			
			//파일의 사용이 끝나면 파일을 닫아줌
			//닫지 않아도 당장 오류는 나지 않지만 파일을 다른 곳에서 사용 불가
			fw.close();
			System.out.println("파일을 생성하였습니다.");
			
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
	}
}
