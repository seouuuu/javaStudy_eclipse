package com.sist.imputoutput;

import java.io.FileWriter;

public class PrintFileHello {

	public static void main(String[] args) {
		//�̸��� ���̸� ���Ϸ� ���
		//���ڴ����� ����� ���� writer�� �ļ� �� ���Ϸ� ����� ���� FileWriter�� ����
		try {	//RuntimeException�� �����Ƿ� try-catch�� �ۼ�
			FileWriter fw = new FileWriter("c:/myData/hello.txt");
			fw.write("�̸��� ȫ�浿�̰�\n");
			fw.write("���̴� 20���Դϴ�.");
			
			//������ ����� ������ ������ �ݾ���
			//���� �ʾƵ� ���� ������ ���� ������ ������ �ٸ� ������ ��� �Ұ�
			fw.close();
			System.out.println("������ �����Ͽ����ϴ�.");
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�:" + e.getMessage());
		}
	}
}
