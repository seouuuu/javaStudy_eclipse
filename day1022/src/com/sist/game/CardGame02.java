package com.sist.game;

public class CardGame02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// CardDeck ��ü ����
		// �����ڿ� ���ؼ� 52���� ī�尡 ������
		CardDeck deck = new CardDeck();
		
		//ī�带 ���� ����
		deck.shuffle();
		
		//ī������� �� ����ڸ� �θ� ����
		Player p1 = new Player();
		Player p2 = new Player();
		
		//�θ��� ����ڰ� ī�带 7�徿 �̱�
		for(int i=0;i<7;i++) {
		p1.getCard(deck.deal());
		p2.getCard(deck.deal());
		}
	
		
		
		//ù��° ����� �ڽ��� ��� ī�� ���
		p1.showCards();
		
		//�ι�° ����� �ڽ��� ��� ī�� ���
		p2.showCards();
		
		if(p1.isOnePair() != 0) {
			System.out.println("player1�� ������Դϴ�." + p1.isOnePair());
		}else {
			System.out.println("player1�� ���� �ƴմϴ�.");
		}
		
		if(p2.isOnePair() != 0) {
			System.out.println("player2�� ������Դϴ�." + p2.isOnePair());
		}else {
			System.out.println("player2�� ���� �ƴմϴ�.");
		}
		
	}
}
