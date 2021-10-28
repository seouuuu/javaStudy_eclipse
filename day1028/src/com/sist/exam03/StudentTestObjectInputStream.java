package com.sist.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

public class StudentTestObjectInputStream {

	public static void main(String[] args) {
		// c:/myData/hong.stu ������ ������ �о�鿩 ��ü�� ���� ȭ�鿡 ���

		try {
			//��ü������ �Է��� ���� ObjectInputStream ��ü ����
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/myData/hong.stu"));
			
			//���Ϸκ��� ��ü�� �о�鿩 ��ü���������� ����
			Student hong = (Student)ois.readObject();
			
			//��ü ���� ���
			System.out.println("�̸�:"+ hong.getName());
			System.out.println("����:"+ hong.getKor());
			System.out.println("����:"+ hong.getEng());
			System.out.println("����:"+ hong.getMath());
			
			//���� �ݱ�
			ois.close();
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}

}
