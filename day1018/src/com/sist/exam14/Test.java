package com.sist.exam14;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*2~5��
		GameCharacter g1 = new Hobitt();
		GameCharacter g2 = new Titan();
		GameCharacter g3 = new Sorcerer();
		
		g1.getLife();
		//g1.getRing();         //����
		((Hobitt)g1).getRing(); //����
		*/
		
		//6��
		/*
		GameCharacter h1 = new Hobitt();
		GameCharacter h2 = new Hobitt();		
		GameCharacter t1 = new Titan();
		GameCharacter t2 = new Titan();
		GameCharacter s1 = new Sorcerer();
		GameCharacter s2 = new Sorcerer();
		
		GameCharacter []arr = {h1,h2,t1,t2,s1,s2};
		*/
		
		//7��
		/*
		for(GameCharacter g:arr) {
			if( g==h1 | g==h2 ) {
				((Hobitt)g).draw();
			} else if ( g==t1 | g==t2 ) {
				((Titan)g).draw();
			} else if (g == s1 | g==s2)
			   ((Sorcerer)g).draw();
			   
	    ȣ���� �׸��ϴ�.
		ȣ���� �׸��ϴ�.
		Ÿ��ź�� �׸��ϴ�.
		Ÿ��ź�� �׸��ϴ�.
		�ּ��縦 �׸��ϴ�.
		�ּ��縦 �׸��ϴ�.
		 */
		}
	
	//8��
	public void drawAll(){
		GameCharacter h1 = new Hobitt();
		GameCharacter h2 = new Hobitt();		
		GameCharacter t1 = new Titan();
		GameCharacter t2 = new Titan();
		GameCharacter s1 = new Sorcerer();
		GameCharacter s2 = new Sorcerer();
		
		GameCharacter []arr = {h1,h2,t1,t2,s1,s2};
		for(GameCharacter g:arr) {
			if( g==h1 | g==h2 ) {
				((Hobitt)g).draw();
			} else if ( g==t1 | g==t2 ) {
				((Titan)g).draw();
			} else if (g == s1 | g==s2)
			   ((Sorcerer)g).draw();
		}
	}
	
	
}
