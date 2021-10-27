package com.sist.game;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Missile extends GraphicObject {
	
	//미사일이 발사되었는지 판별하기 위한 변수
	boolean launched = false;
	
	
	//생성시 이미지파일 이름을 매개변수로 전달받아
	public Missile(String name) {
		
		//부모의 생성자에게 전달
		super(name);
		y = -200;
	}
	
	public void update() {
		//미사일이 발사 되었다면 y좌표를 10씩 감소
		if(launched) {   //launched == true 와 동일
			y -= 10;
		}
		
		//미사일의 y좌표가 화면의 보이지 않는 영역이면 launched에 false 설정
		if(y<-100) {
			launched = false;
		}
	}
	
	
//키보드가 눌러지면 현재 우주선이 있는 위치 x,y 좌표에서부터 출발하여 미사일을 발사하기 위해 keypressed를 오버라이딩
//매개변수로 전달받는 KeyEvent event를 통해 어떤 key가 눌러졌는지 알수 있음
//매개변수 x,y는 우주선의 위치 x,y를 전달받음
	public void keyPressed(KeyEvent event, int x, int y ) {
		//눌러진 키가 스페이스바이면
		if(event.getKeyCode() == KeyEvent.VK_SPACE) {
			//미사일을 발사하기 위해 launched에 true 설정
			launched = true;
			//미사일의 x,y좌표를 우주선의 x,y로 설정
			this.x = x + 32;
			this.y = y;
			
			//미사일 발시 시 소리 발생
			//소리파일 객체 생성
			File file =  new File("LASER.WAV");
			try {
				//오디오파일을 읽어오기 위한 준비
				Clip clip = AudioSystem.getClip();
				//오디오파일 읽어오기
				clip.open(AudioSystem.getAudioInputStream(file));
				//오디오 파일 재생
				clip.start();
			}catch (Exception e) {
				
			}
			
			
		}
	}
}
