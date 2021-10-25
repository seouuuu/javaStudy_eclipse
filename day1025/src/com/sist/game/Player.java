package com.sist.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Player {
	//ī���� ���ڸ� map�� key��
	String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	
	//map �����
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	//���� �̷�� ���� ����� ��Ƴ��� ���� ����Ʈ
	public TreeSet<Integer> pairList = new TreeSet<Integer>();
	
	//������ �ϳ� ����ڰ� CardDeck�� ���� ī�带 �����ͼ� ���� ����Ʈ
	private ArrayList<Card> list = new ArrayList<Card>();
	
	public Player() {
		//"2"�� ���� value�� ���� 2���ϰ� 1�� ����
		int value = 2;
		
		//ī���� ���� �迭��ŭ �ݺ�����
		for(int i=0; i<number.length; i++) {
			//map�� key�� ī���� ����,value�� 2���� 1�� ����
			map.put(number[i], value++);
		}
	}
	
	//ī�带 �Ű������� �޾� list�� ���
	public void getCard(Card card) {
		list.add(card);
	}
	
	public int pairProcess(String player) {
		int n = 0;
		for(int i=0;i<list.size();i++) {
			for(int j=i+1; j<list.size();j++) {
				//i��° ī��� j��° ī�尡 �������� �Ǻ�
				if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
					//������ ī���� ����(���ڿ�)�� �ش��ϴ� ������ map�� ��������
					n=map.get(list.get(i).getNumber());
					//���� �̷�� ���ڸ� pairList�� ���
					pairList.add(n);
				}
			}
		}
		Iterator<Integer> iter = pairList.iterator();
		//pairList�� 3���϶� ū ��2���� ��������
		if(pairList.size()==3) {
			System.out.println(player+"�� ������Դϴ�.");
			//���ڰ� ���� ���� ī�� ������
			iter.next();
			//������ �ΰ� ���� ���ϱ�
			n = iter.next() + iter.next();
		}else if(pairList.size() ==2) { //���� �̷�� ī�尡 2���̸�
			System.out.println(player+"�� ������Դϴ�.");
			//�ΰ��� ���� ���ϱ�
			n = iter.next() + iter.next();
		}else if(pairList.size() ==1) { //���� �̷�� ī�尡 1���̸�
			System.out.println(player+"�� ������Դϴ�.");
			//�� ���ڸ� n�� ���
			n = iter.next();
		}
		return n;
	}
	
	//ī�� ��� ���
	public void showCards() {
		System.out.println(list);
	}
}
