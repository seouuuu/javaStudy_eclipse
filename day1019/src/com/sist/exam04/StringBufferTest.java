package com.sist.exam04;

public class StringBufferTest {
	public static void pro(String str) {
		System.out.println("ó���ϴ� ���ڿ��� "+str+"�Դϴ�.");
	}
	
	public static void main(String[] args) {
		StringBuffer data = new StringBuffer("hello");  //A
		data.append("korea");                           //B
		
		System.out.println(data);
		
		pro(new String(data));
		//�Ǵ�
		String r = new String(data);
		pro(r);
		
	//pro(data);
	//pro�޼ҵ�� String�� �Ű������� ���� ������ StringBuffer�� �����Ҽ� ����
	}
	//A�� data�� B�� data�� ���� �޸𸮸� ����
	//StringBuffer�� ������ �����ص� ���ο� �޸𸮸� ������ �ʰ� ���� ��ü������ �����
	//���ϴ� ���ڿ� ó������ StringBuffer Ȥ�� StringBuilder ���
		
	//StringBuffer�� �Ű������� �����Ͽ� � �޼ҵ带 ����Ҷ���
	//�ٽ� String���� ��ȯ�ؾ��ϴ� ��찡 ����
	//���ڿ��� �Ű������� �޾� ó���ϴ� ��κ��� �޼ҵ�� String�� �޵��� �ϴ� ���� �Ϲ���
	
	//String ������ �� StringBuffer�� �Ű������� ���� ������ �̿�
}
