package com.sist.exam02;

import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class StudentExam {

	public static void main(String[] args) {
		try {
			//파일 읽어오기
			File file = new File("c:/myData/student.txt");
			FileReader fr = new FileReader(file);
			
			//파일 문자 하나씩 읽어서 문자열에 저장
			int n;
			String data = "";				//저장할 문자열
			while((n=fr.read()) != -1) {
				data += (char)n;			//하나씩 가져와서 저장	
			}
			/*
			//split 사용
			String []arr = data.split(",");
			String name = arr[0];
			int kor = Integer.parseInt(arr[1]);
			int eng = Integer.parseInt(arr[2]);
			int math = Integer.parseInt(arr[3]);
			*/
			
			//StringTokenizer 사용
			StringTokenizer st = new StringTokenizer(data,",");
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
	
			int tot = kor + eng + math;
			double avg = tot/3.0;
			
			System.out.println(name + "의 국어: " + kor);
			System.out.println(name + "의 영어: " + eng);
			System.out.println(name + "의 수학: " + math);
			System.out.println(name + "의 총점: " + tot);
			System.out.println(name + "의 평균: " + avg);
			
		}catch (Exception e) {
		}
	}
}
