package com.sist.game02;

import java.util.ArrayList;
import java.util.Collections;

//ī������� ���� 52���� ī�带 �׾Ƶΰ� ī�带 �ϳ��� ������ �� �ִ� �޼ҵ带 ���� Ŭ���� �����
public class CardDeck {
	//Card�� ������ �ִ� ArrayList
	private ArrayList<Card> deck = new ArrayList<Card>();
	
	//�����ڿ��� CardDeck�� �ɹ������� deck�� 52���� ī�带 ����� ���
	public CardDeck() {
		//ī�� ��� 4����
		String []suit = {"Clubs","Diamonds","Hearts","Spades"};
		//ī�� ���� 13����
		String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		
		//��ø�ݺ����� �̿��Ͽ� 52���� ī�� �����ؼ� deck�� ���
		for(int i=0; i<suit.length;i++) {  //ī���縸ŭ �ݺ���
			for(int j=0; j<number.length;j++) {   //ī����ڸ�ŭ �ݺ���
				deck.add(new Card(suit[i],number[j]));
			}
		}
	}
	
	//52���� ī�� ���� ���� �޼ҵ�
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	//52���� ī�尡 �ִ� deck�κ��� ī�带 �ϳ��� �������� deck������ ����� �޼ҵ� �����
	//�׻� deck�� ù��° ��� ��������. deck�� 0��° �ε������ �����ͼ� ����� ��ȯ
	public Card deal() {
		return deck.remove(0);              //��ó���� ȣ��� 52�� �� 0��° ��ȯ
											//�ι�° ȣ��� 51�� �� 0��° ��ȯ
		//ArrayList�� remove�޼ҵ�� �ε����� ��ġ�� �����͸� �����ϰ� ������ �����͸� ��ȯ�ϴ� �޼ҵ�
	}
	
}
