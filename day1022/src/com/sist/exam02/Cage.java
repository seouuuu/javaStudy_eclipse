package com.sist.exam02;

import java.util.ArrayList;

class Animal{
	public void move() {
	}
	
}

class Lion extends Animal{
	public void move() {
		System.out.println("���ڰ� �����Դϴ�.");
	}
}

class Tiger extends Animal{
	public void move() {
		System.out.println("ȣ���̰� �����Դϴ�.");
	}
}

public class Cage {
	//ArrayList<Tiger> list = new ArrayList<Tiger>();
	//list���� Tiger�� ���� �� ����
	
	ArrayList<Animal> list = new ArrayList<Animal>();
	//Animal�� �ļ���(Animal�� is a ���迡 �ִ�) Lion�� ���� �� �ְ� Tiger�� ���� �� ����

	public static void main(String[] args) {
		Cage cage = new Cage();
		cage.list.add(new Lion());
		cage.list.add(new Tiger());
		for(Animal animal :cage.list) {
			animal.move();
		}
	}
}
