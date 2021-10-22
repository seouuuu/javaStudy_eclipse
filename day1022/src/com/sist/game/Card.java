package com.sist.game;

public class Card {
	private String suit;       //카드모양을 위한 멤버변수
	private String number;     //카드숫자를 위한 멤버변수
	
	public Card(String suit, String number) {   //생성시 카드모양과 카드숫자를 매개변수로 받아 초기화
		super();
		this.suit = suit;
		this.number = number;
	}
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {                //카드 모양과 숫자를 문자열로 반환
		return "[" +suit + ","+ number + "]";
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
	
	
}
