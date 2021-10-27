package com.sist.game;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

//플레이어,적,미사일 클래스들이 공통적으로 가져야할 속성과 동작을 일반화
public class GraphicObject {
	
	BufferedImage img = null;  //화면에 그림을 표현하기 위한 객체
	int x=0, y=0;              //그림이 출력될 위치
	
	//생성시 그래픽이미지 파일을 매개변수로 전달받음
	public GraphicObject(String name) {
		
		//매개변수로 전달받은 파일명으로 BufferedImage 객체 생성
		try {
			img = ImageIO.read(new File(name));
		}catch(Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
	}
	
	//그래픽이미지의 위치를 갱신하기위한 메소드. 자식클래스들이 재정의
	public void update() {}
	
	//변경된 위치에 이미지를 다시 그리기 위한 메소드
	public void draw(Graphics g) {
		g.drawImage(img,x,y,null); //x,y 좌표에 이미지를 그리기
	}
	
	//플레이어,적,미사일 객체들이 keyPressed를 자신에게 맞도록 오버라이딩함
	public void keyPressed(KeyEvent event) {}
}
