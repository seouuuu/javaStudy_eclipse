package com.sist.game;

public class Card {
	private String suit;       //ī������ ���� �������
	private String number;     //ī����ڸ� ���� �������
	
	public Card(String suit, String number) {   //������ ī����� ī����ڸ� �Ű������� �޾� �ʱ�ȭ
		super();
		this.suit = suit;
		this.number = number;
	}
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {                //ī�� ���� ���ڸ� ���ڿ��� ��ȯ
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
