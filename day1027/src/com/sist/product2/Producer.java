package com.sist.product2;

//�����ڸ� ���� Ŭ����
public class Producer extends Thread {
	
	//��ǰ�� ���� Ŭ������ �ɹ������� ����
	private Product product;

	//������ ��ü ������ ��ǰ��ü�� �Ű������� ���޹޾� �ɹ����� ��ǰ �ʱ�ȭ
	public Producer(Product product) {
		this.product = product;
	}
	
	//������ Ŭ������ ����Ͽ� ���ο� ��ǰ�� �����ϱ� ���� �޼ҵ带 ȣ���Ű�� ���� 
	//�����尡 �ؾ��ϴ� ���� run�޼ҵ带 �������̵� �Ͽ� �ۼ�
	public void run() {
		//10���� ���ο� ��ǰ�� ����
		for(int i=1; i<=10; i++) {
			product.makeNumber();//���ο� ��ǰ(����)�� �����ϱ� ���� ��ǰ ��ü�� makeNumber�޼ҵ� ȣ��
			try {
				Thread.sleep(200);
			}catch(Exception e) {	
			}
		}
	}
}
