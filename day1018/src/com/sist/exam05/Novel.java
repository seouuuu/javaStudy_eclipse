package com.sist.exam05;

public class Novel extends Book {
	
	public Novel() {
		super();
	}

	public Novel(String number, String title, String author) {
		super(number, title, author);
	}

	@Override
	public int getLateFees(int days) {
		return days*3;
	}
}
