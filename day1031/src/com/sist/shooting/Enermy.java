package com.sist.shooting;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enermy extends GraphicObject {
	
	int dx;
	int dy;

	public Enermy(String name) {
		super(name);
		
		Random r = new Random();
		x = r.nextInt(500);
		y = r.nextInt(300);
		
		dx = r.nextInt()%30 + 10;
		dy = r.nextInt()%30 + 10;
		
		if(dx>=0) {
			dx += 10;
		}else {
			dx -= 10;
		}
		
		if(dy >= 0) {
			dy += 10;
		}else {
			dy -= 10;
		}
	}
	
	public void update() {
	
		x += dx;
		y += dy;
		
		if ( x<0 || x>500) {
			dx = dx * -1;
		}
		
		if( y<0 || y>=300 ) {
	         dy = dy * -1;
	    }
	}
	
	public void crush(Missile missile) {
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

