package com.sist.imputoutput;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		//������ c:/myData/hello.txt ���� �о����
		try {
			File file = new File("c:/myData/hello.txt");
			FileReader fr = new FileReader(file);
			
			int n;
			while((n=fr.read()) != -1) {      
			//while(fr.read() != -1 ) {	 	 //�� ������ ���� - �ϳ��� �ҷ����̱� ����
				System.out.print((char)n); 
				//System.out.print((char)fr.read()); 
			}
			
			fr.close();
		}catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
	}
}
