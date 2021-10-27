package com.sist.game;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enermy extends GraphicObject {
	
	//���� x��,y������ �����̴� ������ ���� ����
	//ó������ ������ ������ �������� �����̵��� �ϱ� ���� ���� ����
	//int dx = -10;
	//int dy = 10;
	
	//���� �̵���θ� ������ �����
	int dx;
	int dy;
	
	//������ ������ ǥ���� �׷��������̸��� �Ű������� ���޹޾� �θ�Ŭ������ �����ڿ��� ����
	public Enermy(String name) {
		super(name);
		
		//��ó�� ���α׷� ����� ���� ��ġ�� ������ ��ܿ� ��ġ��Ű�� ����
		//x = 500;
		//y = 0;
		
		Random r = new Random();
		//��ó�� ���� ��ġ ���� ����
		x = r.nextInt(500);
		x = r.nextInt(300);
		
		
		//���� �̵���ΰ��� �����ÿ� ������ �����
		//�̵��ϴ� �ּҰ�: 10
		//�̵��ϴ� �ִ밪: 40
		//� ������ ���� 30���� ���� �������� 10 ���ϱ�
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
		
		//x��ǥ�� dx��ŭ �����Ŵ. y��ǥ ����
		x += dx;
		y += dy;
		
		//x�� ���� ���������� ��ȣ ����
		if( x<0 || x>500 ) {
			dx = dx * -1;
		}
		
		//y�� ���� ���������� ��ȣ ����
		if( y<0 || y>=300 ) {
			dy = dy * -1;
		}
		
		/*
		//���� ���� ���� ���޽� ���������� �̵���Ű�� ���� dx�� ����� ����
		if(x<0) {
			dx = 10;
		}
		
		//���� ������ ���� ���޽� �������� �̵���Ű�� ����  dx�� ������ ����
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
	//���� �̻��Ͽ� �¾Ҵ��� �Ǻ��ϴ� �޼ҵ� ����
	public void crush(Missile missile){
		
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























