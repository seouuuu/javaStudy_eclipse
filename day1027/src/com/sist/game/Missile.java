package com.sist.game;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Missile extends GraphicObject {
	
	//�̻����� �߻�Ǿ����� �Ǻ��ϱ� ���� ����
	boolean launched = false;
	
	
	//������ �̹������� �̸��� �Ű������� ���޹޾�
	public Missile(String name) {
		
		//�θ��� �����ڿ��� ����
		super(name);
		y = -200;
	}
	
	public void update() {
		//�̻����� �߻� �Ǿ��ٸ� y��ǥ�� 10�� ����
		if(launched) {   //launched == true �� ����
			y -= 10;
		}
		
		//�̻����� y��ǥ�� ȭ���� ������ �ʴ� �����̸� launched�� false ����
		if(y<-100) {
			launched = false;
		}
	}
	
	
//Ű���尡 �������� ���� ���ּ��� �ִ� ��ġ x,y ��ǥ�������� ����Ͽ� �̻����� �߻��ϱ� ���� keypressed�� �������̵�
//�Ű������� ���޹޴� KeyEvent event�� ���� � key�� ���������� �˼� ����
//�Ű����� x,y�� ���ּ��� ��ġ x,y�� ���޹���
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
