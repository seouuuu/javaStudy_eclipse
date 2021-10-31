package com.sist.shooting;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.event.MenuKeyEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class Missile extends GraphicObject {

	boolean launched = false;
	
	public Missile(String name) {
		super(name);
		y = -200;
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		if(launched) {   //launched == true 와 동일
            y -= 10;
        }
		
		if(y<-100) {
            launched = false;
        }
	}
	
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
