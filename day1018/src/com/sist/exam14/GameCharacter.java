package com.sist.exam14;

public class GameCharacter {
	public void draw() {
		System.out.println("GameCharacter()ÀÇ draw()");
	}
	public void getLife() {
		System.out.println("GameCharacter()ÀÇ getLife()");
	}
	
	//8¹ø
	public static void drawAll(GameCharacter[] arr) {
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
	}
}
