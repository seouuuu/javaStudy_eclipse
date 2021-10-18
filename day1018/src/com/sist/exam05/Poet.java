package com.sist.exam05;

public class Poet extends Book {

	public Poet() {
		super();
	}

	public Poet(String number, String title, String author) {
		super(number, title, author);
	}

	@Override
	public int getLateFees(int days) {
		return days*200;
	}

}
