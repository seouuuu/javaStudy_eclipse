package com.sist.exam02;

import java.io.FileWriter;

public class StudentTest {

	public static void main(String[] args) {
		
		Student hong = new Student("ȫ�浿",100,100,100);
		
		//Student ��ü�� hong�� ������ ���Ϸ� ���
		//���ڴ��� - �̸�,����,����,������ ��� ���ڿ��� ����� ���ʷ� ���
		//����Ʈ���� - ��ü�� ��°�� ���

		
		try {
		//���ڴ���
			FileWriter fw = new FileWriter("c:/myData/hong.text");
			
			//��ü�� �̸��� ���Ϸ� ���
			fw.write(hong.getName()+",");
			
			//��ü�� ���������� ���Ϸ� ���
			fw.write(hong.getKor()+",");
			
			//��ü�� ���������� ���Ϸ� ���
			fw.write(hong.getEng()+",");
			
			//��ü�� ���������� ���Ϸ� ���
			fw.write(hong.getMath()+"");  //���ڿ� �����
			
			//������ ��� �Ϸ��� ���� �ݱ�
			fw.close();
			
			System.out.println("���ϻ���");
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}

}
