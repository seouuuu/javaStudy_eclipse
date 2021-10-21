package com.sist.exam06;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

	public static void main(String[] args) {
		
		//컴퓨터와 사용자가 가위/바위/보하는 프로그램
		//컴퓨터가 가위/바위/보중 하나 자동(제비뽑기)
		//사용자에게 가위/바위/보 중 하나 입력받기
		
		//0:가위, 1:바위, 2:보
		
		Scanner sc = new Scanner(System.in);
		
		HashMap<Integer, String> map =new HashMap<Integer, String>();
		map.put(0, "가위");
		map.put(1, "바위");
		map.put(2, "보");
		
		Random r = new Random();
		int com = r.nextInt(3);
		
		System.out.println("0:가위, 1:바위, 2:보");
		System.out.println("선택하세요==>");
		int user = sc.nextInt();
		
		
		System.out.println("컴퓨터는 "+map.get(com)+"를 내었습니다.");
		System.out.println("사용자는 "+map.get(user)+"를 내었습니다.");
		
		if(com == user) {			//비기는 경우
			System.out.println("컴퓨터와 사용자는 비겼습니다.");
		} 
		//사용자가 이기는 경우
		else if(user==0 && com==2|| user ==1 && com == 0|| user==2 && com==1){
			System.out.println("사용자가 이겼습니다.");
		} else {					//사용자가 지는 경우
			System.out.println("컴퓨터가 이겼습니다.");
		}
		
		/*
		if(com ==0 && user ==2) {
			System.out.println("컴퓨터가 이겼습니다.");
		}else if (com==2 && user ==0) {
			System.out.println("사용자가 이겼습니다.");
		}else if(com>user) {
			System.out.println("컴퓨터가 이겼습니다.");
		} else {
			System.out.println("사용자가 이겼습니다.");
		}
		*/
	}
}
