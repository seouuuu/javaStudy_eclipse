package com.sist.game02;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
	
	//게임을 하는 경기자가 CardDeck로부터 카드를 하나씩 가져와 담을 리스트
	private ArrayList<Card> list = new ArrayList<Card>();
	
	//카드를 매개변수로 받아 나의 list에 담기
	public void getCard(Card card) {
		list.add(card);
	}
	
	public int isOnePair() {
		String []number = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		
		//"2"key로 하고 2를 value로 하는 map 만들기 - "jack"이라는 key에는 11이라는 value 담아짐
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		int value = 2;
		
		for(int i=0;i<number.length;i++) {    //카드의 숫자 배열만큼 반복실행
			map.put(number[i], value++);      //map에 key는 카드의 숫자,value는 2부터 1씩 증가
		}
		
		int n = 0;
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				//i번째 카드 숫자와 j번째 카드 숫자가 동일한지 판별
				if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
					//동일한 카드의 숫자(문자열)에 해당하는 정수를 map으로 부터 가져오기
					n = map.get(list.get(i).getNumber());
					return n;
				}
			}
		}
			
		return n;
	}
	
	//투페어 구하는 메소드
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
				//i번째 카드 숫자와 j번째 카드 숫자가 동일한지 판별
				if(list.get(i).getNumber().equals(list.get(j).getNumber())) {
					//숫자 같은 횟수 구하기
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	//트리플 구하는 메소드
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
				//i번째 카드 숫자와 j번째 카드 숫자가 동일한지 판별
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
	
	
	
	//나의 카드를 모두 출력
	public void showCards() {
		System.out.println(list);
	}
	
}
