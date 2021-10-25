package com.sist.game;

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
		
		int n1 = p1.pairProcess("�÷��̾�1");
		int n2 = p2.pairProcess("�÷��̾�2");
		
		if(n1 == n2) {
			System.out.println("�����ϴ�.");
		}else if (n1>n2) {
			System.out.println("�÷��̾�1�� �̰���ϴ�.");
		}else {
			System.out.println("�÷��̾�2�� �̰���ϴ�.");
		}
	}
}
