package com.sist.ars;

//����ڸ� ���� Ŭ������ �����带 ��ӹ޾� ����
public class Donor extends Thread {
	private Account tvArs;		//������� �̸��� ���� �ɹ�����
	private String name;		//����ڵ��� ��ݾ��� �����ϱ� ���� �ɹ������� ����
	
	//����� ��ü ������ ������� �̸��� ������ ��ݾ� ��ü�� �Ű������� ���޹޾� �ɹ������� ����
	public Donor(String name, Account tvArs) {
		this.tvArs = tvArs;
		this.name = name;
	}
	
	//�����尡 �ؾ��� ���� run�� �������̵� �Ͽ� �ۼ�
	public void run() {
		for(int i=1; ;i++){			//��� �ݺ�
			
			//�Ա��ϱ� �� ��ݾ��� 100������ ������ �ݺ����� Ż���ϵ��� ��
			if(tvArs.getBalance() >= 1000000) {
				break;
			}
			
			tvArs.deposit(10000);	//��ݾ� ��ü�� 10000���� �Ա�
			System.out.println(name + "��(��) "+i +"��° �Ա��Ͽ����ϴ�.");	//�Ա� ���� ���
			try {
				Thread.sleep(200);		//0.2�� ���
			}catch(Exception e) {
			}
		}
	}
}
