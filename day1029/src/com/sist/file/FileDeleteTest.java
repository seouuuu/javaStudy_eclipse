package com.sist.file;

import java.io.File;

public class FileDeleteTest {

	public static void main(String[] args) {
		//"c:/myData/�޸�.txt"���� �����ϴ� ���α׷� �ۼ�
		File file = new File("c:/myData/�޸�.txt");
		
		file.delete();
		System.out.println("�����Ͽ����ϴ�.");
	}

}
