package com.sist.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Player {
	//카드의 숫자를 map의 key로
	String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	
	//map 만들기
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	//쌍을 이루는 가드 목록을 담아놓기 위한 리스트
	public TreeSet<Integer> pairList = new TreeSet<Integer>();
	
	//게임을 하년 경기자가 CardDeck로 부터 카드를 가져와서 담을 리스트
	private ArrayList<Card> list = new ArrayList<Card>();
	
	public Player() {
		//"2"에 대한 value를 숫자 2로하고 1씩 증가
		int value = 2;
		
		//카드의 숫자 배열만큼 반복실행
		for(int i=0; i<number.length; i++) {
			//map의 key는 카드의 숫자,value는 2부터 1씩 증가
			map.put(number[i], value++);
		}
	}
	
	//카드를 매개변수로 받아 list에 담기
	public void getCard(Card card) {
		list.add(card);
	}
	
	public int pairProcess(String player) {
		int n = 0;
		for(int i=0;i<list.size();i++) {
			for(int j=i+1; j<list.size();j++) {
				//i번째 카드와 j번째 카드가 동일한지 판별
				if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
					//동일한 카드의 숫자(문자열)에 해당하는 정수를 map에 가져오기
					n=map.get(list.get(i).getNumber());
					//쌍을 이루는 숫자를 pairList에 담기
					pairList.add(n);
				}
			}
		}
		Iterator<Integer> iter = pairList.iterator();
		//pairList가 3개일때 큰 값2개만 가져오기
		if(pairList.size()==3) {
			System.out.println(player+"는 투페어입니다.");
			//숫자가 가장 작은 카드 버리기
			iter.next();
			//나머지 두개 숫자 더하기
			n = iter.next() + iter.next();
		}else if(pairList.size() ==2) { //쌍을 이루는 카드가 2쌍이면
			System.out.println(player+"는 투페어입니다.");
			//두개의 숫자 더하기
			n = iter.next() + iter.next();
		}else if(pairList.size() ==1) { //쌍을 이루는 카드가 1쌍이면
			System.out.println(player+"는 원페어입니다.");
			//그 숫자를 n에 담기
			n = iter.next();
		}
		return n;
	}
	
	//카드 모두 출력
	public void showCards() {
		System.out.println(list);
	}
}
