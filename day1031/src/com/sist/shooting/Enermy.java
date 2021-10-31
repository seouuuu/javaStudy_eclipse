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
	      //���� �̻��Ͽ� �¾Ҵ��� �Ǻ�
        if(missile.x >= x && missile.x <= x+40 && missile.y >= y && missile.y <= y+40) {
            //System.out.println("���� �̻��Ͽ� ����");

            //�Ҹ����� ��ü ����
            File file = new File("EXPLODE.WAV");
            try {
                //����������� �о���� ���� �غ�
                Clip clip = AudioSystem.getClip();
                //��������� �о����
                clip.open(AudioSystem.getAudioInputStream(file));
                //����� ���� ���
                clip.start();
            }catch (Exception e) {

            }
            y = -1000;
        }
    }
}

