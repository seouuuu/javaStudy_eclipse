package com.sist.exam02;

import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class StudentExam {

	public static void main(String[] args) {
		try {
			//���� �о����
			File file = new File("c:/myData/student.txt");
			FileReader fr = new FileReader(file);
			
			//���� ���� �ϳ��� �о ���ڿ��� ����
			int n;
			String data = "";				//������ ���ڿ�
			while((n=fr.read()) != -1) {
				data += (char)n;			//�ϳ��� �����ͼ� ����	
			}
			/*
			//split ���
			String []arr = data.split(",");
			String name = arr[0];
			int kor = Integer.parseInt(arr[1]);
			int eng = Integer.parseInt(arr[2]);
			int math = Integer.parseInt(arr[3]);
			*/
			
			//StringTokenizer ���
			StringTokenizer st = new StringTokenizer(data,",");
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
	
			int tot = kor + eng + math;
			double avg = tot/3.0;
			
			System.out.println(name + "�� ����: " + kor);
			System.out.println(name + "�� ����: " + eng);
			System.out.println(name + "�� ����: " + math);
			System.out.println(name + "�� ����: " + tot);
			System.out.println(name + "�� ���: " + avg);
			
		}catch (Exception e) {
		}
	}
}
