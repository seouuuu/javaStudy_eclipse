package com.sist.game;
import java.awt.event.KeyEvent;

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
		//�̻����� �߻� �Ǿ��ٸ� y��ǥ�� 1�� ����
		if(launched) {   //launched == true �� ����
			y -= 1;
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
		}
	}
}
