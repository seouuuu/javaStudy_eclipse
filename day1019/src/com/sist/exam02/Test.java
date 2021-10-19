package com.sist.exam02;

public class Test {
	// 8번
	public static void drawAll(GameCharacter []arr) {
		for(GameCharacter character : arr) {
			character.draw();
			
			//((Hobitt)character).getRing();
			//오류
			
			if(character instanceof Hobitt) {
				((Hobitt)character).getRing();
			}
		}
	}
	
	/*9번
	public static void drawAll(Object []arr) {
		for(Object character : arr) {
			((GameCharacter)character).draw();
		}
	}
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameCharacter g1 = new Hobitt();
		//is a 관계에 있을때 부모의 참조변수가 자식클래스의 객체를 참조할 수 있음
		
		g1.getLife();
		//객체가 메세지를 받으면 자신의 클래스에서 먼저 찾고
		//없으면 부모클래스 메소드 동작
		
		//g1.getRing();
		//오류
		//is a 관계에 있을때 부모의 참조변수가 자식클래스의 객체 참조 가능하지만
		//자식클래스에 새롭게 추가한 메소드를 바로 호출할 수 없음.형변환 필요
		((Hobitt)g1).getRing();
		
		System.out.println("-------------------------------");
		
		/*
		GameCharacter []arr = new GameCharacter[6];
		arr[0] = new Hobitt();
		arr[1] = new Hobitt();
		arr[2] = new Titan();
		arr[3] = new Titan();
		arr[4] = new Sorcerer();
		arr[5] = new Sorcerer();
		*/
		
		GameCharacter []arr = {
				new Hobitt(),
				new Hobitt(),
				new Titan(),
				new Titan(),
				new Sorcerer(),
				new Sorcerer(),	
		};
		/*
		for(GameCharacter character : arr) {
			character.draw();
		}
		*/
		drawAll(arr);
		
	}
}
