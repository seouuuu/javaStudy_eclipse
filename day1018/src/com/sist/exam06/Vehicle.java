package com.sist.exam06;

public abstract class Vehicle {
	protected int speed;
	public void printSpeed(int speed) {
		System.out.println("현재속도:"+speed);
	}
	public abstract double getKilosPerLiter();
}
