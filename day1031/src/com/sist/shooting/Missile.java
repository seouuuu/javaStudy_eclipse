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
		if(launched) {   //launched == true �� ����
            y -= 10;
        }
		
		if(y<-100) {
            launched = false;
        }
	}
	
	public void keyPressed(KeyEvent event, int x, int y ) {
        //������ Ű�� �����̽����̸�
        if(event.getKeyCode() == KeyEvent.VK_SPACE) {
            //�̻����� �߻��ϱ� ���� launched�� true ����
            launched = true;
            //�̻����� x,y��ǥ�� ���ּ��� x,y�� ����
            this.x = x + 32;
            this.y = y;

            //�̻��� �߽� �� �Ҹ� �߻�
            //�Ҹ����� ��ü ����
            File file =  new File("LASER.WAV");
            try {
                //����������� �о���� ���� �غ�
                Clip clip = AudioSystem.getClip();
                //��������� �о����
                clip.open(AudioSystem.getAudioInputStream(file));
                //����� ���� ���
                clip.start();
            }catch (Exception e) {
            }
        }
    }

}
