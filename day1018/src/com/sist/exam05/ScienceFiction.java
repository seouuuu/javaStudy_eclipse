package com.sist.exam05;

public class ScienceFiction extends Book {
	public ScienceFiction() {
		super();
	}

	public ScienceFiction(String number, String title, String author) {
		super(number, title, author);
	}

	@Override
	public int getLateFees(int days) {
		return days*600;
	}

}
