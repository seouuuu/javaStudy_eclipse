package com.sist.exam02;

import java.io.FileWriter;

public class StudentFileWriter {

	public static void main(String[] args) {
		
		try {
			//���ϻ���
			FileWriter fw = new FileWriter("c:/myData/student.txt");
			fw.write("ȫ�浿,100,80,90");
			fw.close();
			System.out.println("���� ���� �Ϸ�");
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}

	}

}
