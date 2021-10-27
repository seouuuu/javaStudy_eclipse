package com.sist.game;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enermy extends GraphicObject {
	
	//적이 x축,y축으로 움직이는 간격을 위한 변수
	//처음에는 오른쪽 끝에서 왼족으로 움직이도록 하기 위해 음수 설정
	//int dx = -10;
	//int dy = 10;
	
	//적의 이동경로를 난수로 만들기
	int dx;
	int dy;
	
	//생성시 적으로 표현할 그래픽파일이름을 매개변수로 전달받아 부모클래스의 생성자에게 전달
	public Enermy(String name) {
		super(name);
		
		//맨처음 프로그램 실행시 적의 위치를 오른쪽 상단에 위치시키기 위해
		//x = 500;
		//y = 0;
		
		Random r = new Random();
		//맨처음 적의 위치 난수 설정
		x = r.nextInt(500);
		x = r.nextInt(300);
		
		
		//적의 이동경로값을 생성시에 난수로 만들기
		//이동하는 최소값: 10
		//이동하는 최대값: 40
		//어떤 난수로 만들어서 30으로 나눈 나머지에 10 더하기
		dx = r.nextInt() % 30 + 10;
		dy = r.nextInt() % 30 + 10;
		
		if(dx >= 0) {
			dx += 10;
		}else {
			dx -= 10;
		}
		
		if(dy >= 0 ) {
			dy += 10;
		}else{
			dy -= 10;
		}
		
		System.out.println("dx:"+ dx);
		System.out.println("dy:"+ dy);
	}
	
	public void update() {
		
		//x좌표를 dx만큼 변경시킴. y좌표 동일
		x += dx;
		y += dy;
		
		//x축 끝에 도착했으면 부호 변경
		if( x<0 || x>500 ) {
			dx = dx * -1;
		}
		
		//y축 끝에 도착했으면 부호 변경
		if( y<0 || y>=300 ) {
			dy = dy * -1;
		}
		
		/*
		//만약 왼쪽 끝에 도달시 오른쪽으로 이동시키기 위해 dx를 양수로 만듬
		if(x<0) {
			dx = 10;
		}
		
		//만약 오른쪽 끝에 도달시 왼쪽으로 이동시키기 위해  dx를 음수로 만듬
		if(x>500) {
			dx = -10;
		}
		
		if(y>400) {
			dy = -10;
		}
		
		if(y<0) {
			dy = 10;
		}
		*/
			
			
			
	}
	//적이 미사일에 맞았는지 판별하는 메소드 정의
	public void crush(Missile missile){
		
		//적이 미사일에 맞았는지 판별
		if(missile.x >= x && missile.x <= x+40 && missile.y >= y && missile.y <= y+40) {
			//System.out.println("적이 미사일에 맞음");
			
			//소리파일 객체 생성
			File file = new File("EXPLODE.WAV");
			try {
				//오디오파일을 읽어오기 위한 준비
				Clip clip = AudioSystem.getClip();
				//오디오파일 읽어오기
				clip.open(AudioSystem.getAudioInputStream(file));
				//오디오 파일 재생
				clip.start();
			}catch (Exception e) {
				
			}
			
			y = -1000;
			
		}
	}
		
}























