package com.sist.exam04;

public class StringTestEquals {

	public static void main(String[] args) {
		String data1 = new String("ȫ�浿");
		String data2 = new String("ȫ�浿");
		/*
		if(data1==data2) {  //�����ڷ������� ==�� ���� �޸𸮸� �ٶ󺸴��� �Ǻ�
			System.out.println("���� ���ƿ�");
		}else
			System.out.println("���� �޶��");
	   //���� �޶�� ���
	*/
		if(data1.equals(data2)) {  //�����ڷ������� ==�� ���� �޸𸮸� �ٶ󺸴��� �Ǻ�
			System.out.println("���� ���ƿ�");
		}else
			System.out.println("���� �޶��");
		 // ���� ���ƿ� ���
		
		System.out.println("------------------------------");
		
		String name1 = new String("tiger");
		String name2 = new String("Tiger");
		
		if(name1.equals(name2)) {
			System.out.println("�̸��� tiger�� ���ƿ�");
		} else
			System.out.println("�̸��� ���� �ʾƿ�");
		
System.out.println("------------------------------");
		
		String name3 = new String("tiger");
		String name4 = new String("Tiger");
		
		if(name4.equalsIgnoreCase(name4)) {
			System.out.println("�̸��� tiger�� ���ƿ�");
		} else
			System.out.println("�̸��� ���� �ʾƿ�");
		
	}
}
