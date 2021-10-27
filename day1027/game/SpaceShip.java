package com.sist.game;
import java.awt.event.KeyEvent;

//우주선(플레이어)를 위한 클래스
public class SpaceShip extends GraphicObject {
	
	//생성시 이미지파일명을 매개변수로 전달받아 부모의 생성자에게 전달
	public SpaceShip(String name) {
		super(name);
		//처음 우주선의 위치 설정
		x = 200;
		y = 380;
	}
	
	//우주선에 눌러진 방향키에 따라 우주선의 위치 이동
	//매개변수로 전달받은 키 이벤트를 통해 어떤키가 눌러졌는지 알 수 있음
	public void keyPressed(KeyEvent event) {
		//왼쪽방향키가 눌러지면
		if(event.getKeyCode() == KeyEvent.VK_LEFT) {
			//x좌표를 왼쪽으로 이동시키기 위해 10감소
			x -= 10;
		}
		//오른쪽방향키가 눌러지면
		if(event.getKeyCode() == KeyEvent.VK_RIGHT) {
			//x좌표를 오른쪽으로 이동시키기 위해 10증가
			x += 10;
		}
		//위쪽방향키가 눌러지면
		if(event.getKeyCode() == KeyEvent.VK_UP) {
			//y좌표를 위쪽으로 이동시키기 위해 10감소
			y -= 10;
		}
		//아래쪽방향키가 눌러지면
		if(event.getKeyCode() == KeyEvent.VK_DOWN) {
			//y좌표를 아래쪽으로 이동시키기 위해 10증가
			y += 10;
		}

		
		
	}

}
