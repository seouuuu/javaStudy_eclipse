package com.sist.ars;

public class TVArsTest {

	public static void main(String[] args) {
		//��ݾ� ���� ����
		Account account = new Account();
		
		//5���� ����� ��ü ����, ���� ���� ����
		Donor d1 = new Donor("ȫ�浿",account);
		Donor d2 = new Donor("�̼���",account);
		Donor d3 = new Donor("������",account);
		Donor d4 = new Donor("������",account);
		Donor d5 = new Donor("������",account);
		
		//5���� ����ڵ��� �����ϰ� �Ա��ϵ��� ������ ����
		d1.start();
		d2.start();
		d3.start();
		d4.start();
		d5.start();
		
		//������ �۾� �Ϸ���� ����ϱ� ���� join�޼ҵ� ȣ��
		try {
			d1.join();
			d2.join();
			d3.join();
			d4.join();
			d5.join();
		}catch(Exception e) {
		}
		
		System.out.println("��ü��ݾ�: "+account.getBalance());
	}
}
