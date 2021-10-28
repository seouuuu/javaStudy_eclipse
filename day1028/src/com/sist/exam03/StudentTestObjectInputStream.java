package com.sist.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

public class StudentTestObjectInputStream {

	public static void main(String[] args) {
		// c:/myData/hong.stu 파일의 내용을 읽어들여 객체의 정보 화면에 출력

		try {
			//객체단위로 입력을 위한 ObjectInputStream 객체 생성
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/myData/hong.stu"));
			
			//파일로부터 객체를 읽어들여 객체참조변수에 저장
			Student hong = (Student)ois.readObject();
			
			//객체 정보 출력
			System.out.println("이름:"+ hong.getName());
			System.out.println("국어:"+ hong.getKor());
			System.out.println("영어:"+ hong.getEng());
			System.out.println("수학:"+ hong.getMath());
			
			//파일 닫기
			ois.close();
			
		}catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}

}
