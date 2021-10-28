package com.sist.exam03;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;

public class StudentTestObjectOutStream {

	public static void main(String[] args) {
		
		Student hong = new Student("ȫ�浿",100,100,100);
		
		//Student ��ü�� hong�� ������ ���Ϸ� ���
		//���ڴ��� - �̸�,����,����,������ ��� ���ڿ��� ����� ���ʷ� ���
		//����Ʈ���� - ��ü�� ��°�� ���

		//����Ʈ����(��ü����)�� ���
		try {
			//��ü������ ����ϱ� ���� ObjectOutputStream ����
			//�̶� Ȯ���ڴ� �ؽ�Ʈ������ �ƴϹǷ� .txt�� ����
			//���α׷��� ���ݿ� �µ��� ����
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/myData/hong.stu"));
			
			//��ü�� ���
			oos.writeObject(hong);
			
			//���� ��� �Ϸ��� �ݱ�
			oos.close();
			
			System.out.println("������ �����Ǿ����ϴ�.");
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}

}

