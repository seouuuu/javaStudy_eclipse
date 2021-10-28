package com.sist.draw07;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class LinePanel extends JPanel implements MouseListener{

    int x1 = 0;
	int y1 = 0;
	int x2 = 0;
	int y2 = 0;
	
	//선,원,사각형 중 선택할 변수 선언
	//선:0
	//사각형:1
	//원:2
	int drawType;
	
	//사용자가 그린 선들을 담기 위한 리스트 선언
	ArrayList<GraphicInfo> list;
	
	//생성자에서 "마우스이벤트"를 등록
	public LinePanel() {
		
		//리스트 생성
		list = new ArrayList<GraphicInfo>();
		
		//this의 의미는 마우스이벤트가 발생하였을때 이벤트처리 담당객체가 "자신"이라는 의미
		addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		//부모의 paintComponent를 요청하여 화면 깨끗이 지우기
		super.paintComponent(g);
		
		//리스트에 담긴 모든 선을 그리기
		for( GraphicInfo info : list) {
			x1 = info.getX1();
			y1 = info.getY1();
			x2 = info.getX2();
			y2 = info.getY2();
			int width = x2 - x1;
			int height = y2 - y1;
			
			switch(info.getDrawType()) {
				case 0:g.drawLine(x1,y1,x2,y2);break;
				case 1:g.drawRect(x1,y1,width,height);break;
				case 2:g.drawOval(x1,y1,width,height);break;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {	//마우스가 눌러질 때
		x1 = e.getX();
		y1 = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {	//마우스에서 손을 떼었을 때
		x2 = e.getX();
		y2 = e.getY();
		
//하나의 선이 완성될때 선의 시작점x, 시작점y, 끝점x, 끝점y를 가지고 있는 GraphicInfo 객체생성 후 리스트에 담기
		list.add(new GraphicInfo(x1, y1, x2, y2, drawType));
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
