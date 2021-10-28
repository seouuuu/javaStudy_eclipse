package com.sist.exam01;

import java.io.FileReader;

public class StudentTest {

	public static void main(String[] args) {
			
		//�ؽ�Ʈ������ ������ ��ǻ�� �޸𸮷� �о���̱� ���� FileReaderŬ���� �̿�
		//FileReader�� �����ڴ� "����"��  ������ ����
		try {
			FileReader fr = new FileReader("c:/myData/student.txt");
			//���Ϸκ��� �ѱ��ھ� �о���̴� �޼ҵ� : read(), �о���� ������ ������ ��ȯ
			//������ ���� �����ϸ� -1 ��ȯ
			
			//�о���� ���ڵ��� ��� ���ڿ��� ����� ���� ����
			//�ѹ��ھ� �о�鿩 �����ϱ� ���� �ʱⰪ ""����
			String str = "";
			
			int ch;		//���Ϸ� ���� �ѱ��ھ� �о���̱� ���� ����
			while( true ) {
				ch = fr.read();	//���Ϸκ��� �ѱ��ھ� �о����
				if(ch == -1) {	//������ ���� �����ϸ� �ݺ���Ż��
					break;
				}
				//�о���� ������ �������� ���ڷ� ����ȯ
				char data = (char)ch;
				//System.out.print(data);	
				
				//�о���� ���ڸ� ���ڿ� ���� str�� ����
				str += data;
			}//������ ������ ��� ������ �ݺ��� Ż��
			
			//���� ��� �Ϸ��� ���� �ݱ�
			fr.close();
			
			System.out.println(str);
			
			//","�� ���ڿ� �и� - split/StringTokenizer
			String []arr = str.split(",");
			String name = arr[0];	
			int kor = Integer.parseInt(arr[1]);		
			int eng = Integer.parseInt(arr[2]);
			int math = Integer.parseInt(arr[3]);
			
			int tot = kor + eng + math;
			int avg = tot/3;
			
			System.out.println("�̸�:"+ name);
			System.out.println("����:"+ kor);
			System.out.println("����:"+ eng);
			System.out.println("����:"+ math);
			System.out.println("����:"+ tot);
			System.out.println("���:"+ avg);
			
		}catch (Exception e) {
			//���ܰ� �߻��Ǹ� ���ܸ޼��� ���
			System.out.println("���ܹ߻�: " + e.getMessage());
		}
	}
}
