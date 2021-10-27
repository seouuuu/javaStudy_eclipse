package com.sist.imputoutput;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		//생성한 c:/myData/hello.txt 파일 읽어오기
		try {
			File file = new File("c:/myData/hello.txt");
			FileReader fr = new FileReader(file);
			
			int n;
			while((n=fr.read()) != -1) {      
			//while(fr.read() != -1 ) {	 	 //로 했을때 오류 - 하나씩 불러들이기 때문
				System.out.print((char)n); 
				//System.out.print((char)fr.read()); 
			}
			
			fr.close();
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
	}
}
