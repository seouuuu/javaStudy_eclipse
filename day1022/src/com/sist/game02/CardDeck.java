package com.sist.game02;

import java.util.ArrayList;
import java.util.Collections;

//카드게임을 위한 52장의 카드를 쌓아두고 카드를 하나씩 가져올 수 있는 메소드를 갖는 클래스 만들기
public class CardDeck {
	//Card를 담을수 있는 ArrayList
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	//생성자에서 CardDeck의 맴버변수인 deck에 52장의 카드를 만들어 담기
	public CardDeck() {
		//카드 모양 4가지
		String []suit = {"Clubs","Diamonds","Hearts","Spades"};
		//카드 숫자 13가지
		String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		
		//중첩반복문을 이용하여 52개의 카드 생성해서 deck에 담기
		for(int i=0; i<suit.length;i++) {  //카드모양만큼 반복문
			for(int j=0; j<number.length;j++) {   //카드숫자만큼 반복문
				deck.add(new Card(suit[i],number[j]));
			}
		}
	}
	
	//52개의 카드 순서 섞는 메소드
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	//52장의 카드가 있는 deck로부터 카드를 하나씩 가져오고 deck에서는 지우는 메소드 만들기
	//항상 deck의 첫번째 요소 가져오기. deck의 0번째 인덱스요소 가져와서 지우고 반환
	public Card deal() {
		return deck.remove(0);              //맨처음에 호출시 52장 중 0번째 반환
											//두번째 호출시 51장 중 0번째 반환
		//ArrayList의 remove메소드는 인덱스에 위치한 데이터를 제거하고 제거한 데이터를 반환하는 메소드
	}
	
}
