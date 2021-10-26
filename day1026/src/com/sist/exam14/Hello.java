package com.sist.exam14;

import java.util.Date;

public class Hello extends Thread {
	public void run() {
		while(true) {
			Date now = new Date();
			System.out.println(now + " æ»≥Á«œººø‰?");
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
			}
		}
	}
}
