package com.sist.exam02;

import java.io.FileWriter;

public class StudentFileWriter {

	public static void main(String[] args) {
		
		try {
			//파일생성
			FileWriter fw = new FileWriter("c:/myData/student.txt");
			fw.write("홍길동,100,80,90");
			fw.close();
			System.out.println("파일 생성 완료");
			
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}

	}

}
