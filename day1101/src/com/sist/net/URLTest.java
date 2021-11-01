package com.sist.net;

import java.io.InputStream;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) {
		
		try {
			//���ͳݻ��� ������ü ����
			URL url = new URL("https://www.hanbit.co.kr/store/books/new_book_list.html");
			
			//������ ������ �о���� ���� ��Ʈ�� ����
			InputStream is =  url.openStream();
			
			//�Ѳ����� �о���� byte���� �迭�� �����
			byte []data = new byte[100];
			
			//��Ʈ���� ���� �о�� ���ڿ��� �� ��Ƴ��� ������ �����
			String str = "";
			
			//��Ʈ���� ���� �ƴҶ����� 100����Ʈ�� �о����
			while( is.read(data) != -1 ) {
				
				//�о���� byte�迭�� �����͸� ���ڿ��� ����� ����
				str += new String(data,"utf-8");
			}
			
			//��ü ������ ���ڿ� ������ ���
			System.out.println(str);
			
			//��Ʈ�� �ݱ�
			is.close();
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}

}
