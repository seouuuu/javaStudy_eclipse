package com.sist.exam02;

import java.util.ArrayList;

class Animal{
	public void move() {
	}
	
}

class Lion extends Animal{
	public void move() {
		System.out.println("사자가 움직입니다.");
	}
}

class Tiger extends Animal{
	public void move() {
		System.out.println("호랑이가 움직입니다.");
	}
}

public class Cage {
	//ArrayList<Tiger> list = new ArrayList<Tiger>();
	//list에는 Tiger만 담을 수 있음
	
	ArrayList<Animal> list = new ArrayList<Animal>();
	//Animal의 후손인(Animal과 is a 관계에 있는) Lion도 담을 수 있고 Tiger도 담을 수 있음

	public static void main(String[] args) {
		Cage cage = new Cage();
		cage.list.add(new Lion());
		cage.list.add(new Tiger());
		for(Animal animal :cage.list) {
			animal.move();
		}
	}
}
