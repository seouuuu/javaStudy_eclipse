package com.sist.product2;

public class MainTest {

	public static void main(String[] args) {
		//��ǰ ��ü ����
		Product product = new Product();
		
		//������ ������ ��ü ����
		Producer producer = new Producer(product);
		
		//�Һ��� ������ ��ü ����
		Consumer consumer = new Consumer(product);
		
		//�����ڿ� �Һ��� ����
		producer.start();
		consumer.start();
	}
}
