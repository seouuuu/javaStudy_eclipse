package com.sist.exam05;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		
		Date today = new Date();
		int year = today.getYear() + 1900;
		int month = today.getMonth() +1;
		int date = today.getDate();
		int hours = today.getHours();
		int minutes = today.getMinutes();
		int seconds = today.getSeconds();
		int day = today.getDay();
		//�ڵ忡 ��Ҽ��� �׾����� ���� Calendar�� GregorianCalendar ��� ����
		
		String []arr = {"��","��","ȭ","��","��","��","��"};
		String data = arr[day];
		
		
		/*
		String str = "";
		switch(day) {
		case 0: str = "��";break;
		case 1: str = "��";break;
		case 2: str = "ȭ";break;
		case 3: str = "��";break;
		case 4: str = "��";break;
		case 5: str = "��";break;
		case 6: str = "��";break;
		}
		*/
		
		System.out.println(day);
		System.out.printf("����� %d�� %d�� %d��(%s����) %d�� %d�� %d���Դϴ�.\n",year,month,date,data,hours,minutes,seconds);
		
		System.out.println("-------------------------------------");
		//Ư����¥�� ���� ���ϱ�
		int birthYear = 1995;
		int birthMonth = 7;
		int birthDate = 29;
		Date Date2 = new Date(birthYear-1900, birthMonth-1,birthDate);   //����-1900/month�ε��� 0�����̱⶧���� -1
		int birthday = Date2.getDay();
		System.out.print(arr[birthday]);
		
		
		
	}
}
