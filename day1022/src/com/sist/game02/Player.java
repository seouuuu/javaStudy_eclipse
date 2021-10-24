package com.sist.game02;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	
	//������ �ϴ� ����ڰ� CardDeck�κ��� ī�带 �ϳ��� ������ ���� ����Ʈ
	private ArrayList<Card> list = new ArrayList<Card>();
	
	//ī�带 �Ű������� �޾� ���� list�� ���
	public void getCard(Card card) {
		list.add(card);
	}
	
	public int isOnePair() {
		String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		
		//"2"key�� �ϰ� 2�� value�� �ϴ� map ����� - "jack"�̶�� key���� 11�̶�� value �����
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		int value = 2;
		
		for(int i=0;i<number.length;i++) {    //ī���� ���� �迭��ŭ �ݺ�����
			map.put(number[i], value++);      //map�� key�� ī���� ����,value�� 2���� 1�� ����
		}
		
		int n = 0;
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				//i��° ī�� ���ڿ� j��° ī�� ���ڰ� �������� �Ǻ�
				if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
					//������ ī���� ����(���ڿ�)�� �ش��ϴ� ������ map���� ���� ��������
					n = map.get(list.get(i).getNumber());
					return n;
				}
			}
		}
			
		return n;
	}
	
	//����� ���ϴ� �޼ҵ�
	public int isTwoPair() {
		String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		int value = 2;

		for(int i=0;i<number.length;i++) {    
			map.put(number[i], value++);      
		}

		int cnt = 0;
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				//i��° ī�� ���ڿ� j��° ī�� ���ڰ� �������� �Ǻ�
				if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
					//���� ���� Ƚ�� ���ϱ�
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	//Ʈ���� ���ϴ� �޼ҵ�
	public int isTriple() {
		String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		int value = 2;

		for(int i=0;i<number.length;i++) {    
			map.put(number[i], value++);      
		}

		int n = 0;
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				//i��° ī�� ���ڿ� j��° ī�� ���ڰ� �������� �Ǻ�
				if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
					for(int k=j+1;k<list.size();k++) {
						if(list.get(j).getNumber().equals(list.get(k).getNumber())) {
							n = map.get(list.get(j).getNumber());
							return n;
						}
					}
				}
			}
		}
		return n;
	}
	
	
	
	//���� ī�带 ��� ���
	public void showCards() {
		System.out.println(list);
	}
	
}
