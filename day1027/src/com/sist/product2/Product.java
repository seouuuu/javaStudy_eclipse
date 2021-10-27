package com.sist.product2;
//wait, notify ������
import java.util.Random;

//�����ڿ� �Һ��ڰ� ������ ��ǰ Ŭ����
public class Product {
	
	//����Ǵ� ��ǰ�� ������ ������ ��
	int number;
	
	//��ǰ�� ���� �����Ͽ����� �Һ��Ͽ����� �Ǻ��ϱ� ���� ����
	//�����ڰ� ���ο� ��ǰ�� �����ϸ� true ����
	//�Һ��ڰ� ��ǰ�� �Һ��ϸ� false ����
	public boolean isNew = false;
	
	//�����ڰ� ����� ���ο� ��ǰ�� �����ϴ� �޼ҵ� ����
	//�����ڰ� ��ǰ�� �����ϰ� �ִ� ���� �Һ��ڰ� ������ �� ������ �ϱ� ���� �Ӱ迵������ ����
	public synchronized void makeNumber() {
		
		//���ο� ��ǰ(����)�� ������ �����
		Random r = new Random();
		number = r.nextInt(100);	//���ο� ��ǰ ����
		System.out.println("�����ڰ� ���ο� ��ǰ ���� ==>" + number);
					
	}
	
	//�Һ��ڰ� ����� ��ǰ�� �Һ��ϱ� ���� �޼ҵ� ����
	public synchronized int getNumber() {
		
		System.out.println("�Һ��ڰ� ��ǰ �Һ�==>"+ number);	//�Һ��ڰ� ��ǰ�� �Һ�
		
		return number;
	}
}
