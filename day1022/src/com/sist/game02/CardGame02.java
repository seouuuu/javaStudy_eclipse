package com.sist.game02;

public class CardGame02 {

	public static void main(String[] args) {
		
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
		
		//�����Ȯ��
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
		
		//����� Ȯ��
		if(p1.isTwoPair() == 2) {
			System.out.println("player1�� ������Դϴ�.");
		}else {
			System.out.println("player1�� ���� �ƴմϴ�.");
		}
		if(p2.isTwoPair() == 2) {
			System.out.println("player2�� ������Դϴ�.");
		}else {
			System.out.println("player2�� ���� �ƴմϴ�.");
		}
		
		//Ʈ����Ȯ��
		if(p1.isTriple() != 0) {
			System.out.println("player1�� Ʈ�����Դϴ�." + p1.isTriple());
		}else {
			System.out.println("player1�� Ʈ������ �ƴմϴ�.");
		}
		if(p2.isTriple() != 0) {
			System.out.println("player2�� Ʈ�����Դϴ�." + p2.isTriple());
		}else {
			System.out.println("player2�� Ʈ������ �ƴմϴ�.");
		}
			
		
	
		
		
		
		
		
		
	}
}
