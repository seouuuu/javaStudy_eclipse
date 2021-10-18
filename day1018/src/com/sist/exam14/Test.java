package com.sist.exam14;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*2~5번
		GameCharacter g1 = new Hobitt();
		GameCharacter g2 = new Titan();
		GameCharacter g3 = new Sorcerer();
		
		g1.getLife();
		//g1.getRing();         //오류
		((Hobitt)g1).getRing(); //가능
		*/
		
		//6번
		GameCharacter []arr = new GameCharacter[6];
		arr[0] = new Hobitt();
		arr[1] = new Hobitt();
		arr[2] = new Titan();
		arr[3] = new Titan();
		arr[4] = new Sorcerer();
		arr[5] = new Sorcerer();
		
		//7번
		/*
		for(int i=0 ; i<arr.length; i++) {
			switch(i) {
			case 0:
			case 1: ((Hobitt)arr[i]).draw();break;
			case 2:
			case 3: ((Titan)arr[i]).draw();break;
			case 4:
			case 5: ((Sorcerer)arr[i]).draw();break;
			}
		}
		*/
		/*	   
	    호빗을 그립니다.
		호빗을 그립니다.
		타이탄을 그립니다.
		타이탄을 그립니다.
		주술사를 그립니다.
		주술사를 그립니다.
		*/
		
		//8번
		//drawAll.arr();
		}
	
		
	}
	
	
