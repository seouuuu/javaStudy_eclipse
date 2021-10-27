package com.sist.product;

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
		
		//���ο� ��ǰ(����)�� �����ϱ� ���� �Һ� �Ͼ�� �ʴµ��� ������
		//�Һ��ڰ� ��ǰ�� �Һ��ϰ� isNew�� false�� �����ϰ� notify�� �����ָ� �ݺ��� Ż��
		while(isNew == true) {		//true:�Һ� �Ͼ�� ����
			try {
				wait();
			}catch(Exception e) {
			}
		}
		
		//���ο� ��ǰ(����)�� ������ �����
		Random r = new Random();
		number = r.nextInt(100);	//���ο� ��ǰ ����
		System.out.println("�����ڰ� ���ο� ��ǰ ���� ==>" + number);
		isNew = true;				//���ο� ��ǰ�� ����Ǿ��ٴ� ǥ�÷� isNew�� true ����
		notify();					//������� ������(�Һ���)�� ������
	}
	
	//�Һ��ڰ� ����� ��ǰ�� �Һ��ϱ� ���� �޼ҵ� ����
	public synchronized int getNumber() {
		
		//�����ڰ� ���ο� ��ǰ�� ������ ������ ������(���ο� ��ǰ�� �������� �ʴ� ����)
		//�����ڰ� ���ο� ��ǰ�� �����ϰ� isNew�� true�� ��� notify�� �����ָ� �ݺ��� Ż��
		while(isNew = false) {
			try {
				wait();
			}catch(Exception e) {
			}
		}
		
		System.out.println("�Һ��ڰ� ��ǰ �Һ�==>"+ number);	//�Һ��ڰ� ��ǰ�� �Һ�
		isNew = false;	//�Һ��ڰ� ��ǰ�� �Һ��Ͽ��ٴ� ǥ�÷� isNew�� false ����
		notify();		//������� ������ ������
		return number;
	}
}
