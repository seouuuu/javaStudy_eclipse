package com.sist.exam06;

public abstract class Vehicle {
	protected int speed;
	public void printSpeed(int speed) {
		System.out.println("����ӵ�:"+speed);
	}
	public abstract double getKilosPerLiter();
}
