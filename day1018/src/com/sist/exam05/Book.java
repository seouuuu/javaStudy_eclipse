package com.sist.exam05;

import java.util.Objects;

public abstract class Book {
	protected String number;
	protected String title;
	protected String author;
	
	@Override
	public int hashCode() {
		return Objects.hash(author, number, title);
	}

	public boolean equals(Object obj) {
		if( number.equals( ((Book)obj).number )) {
			return true;
		} else
			return false;
	}

	public Book(String number, String title, String author) {
		super();
		this.number = number;
		this.title = title;
		this.author = author;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Book [number=" + number + ", title=" + title + ", author=" + author + "]";
	}

	public abstract int getLateFees(int days);

}
