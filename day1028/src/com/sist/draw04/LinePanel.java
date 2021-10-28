package com.sist.draw04;

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
	
	//����ڰ� �׸� ������ ��� ���� ����Ʈ ����
	ArrayList<GraphicInfo> list;
	
	//�����ڿ��� "���콺�̺�Ʈ"�� ���
	public LinePanel() {
		
		//����Ʈ ����
		list = new ArrayList<GraphicInfo>();
		
		//this�� �ǹ̴� ���콺�̺�Ʈ�� �߻��Ͽ����� �̺�Ʈó�� ��簴ü�� "�ڽ�"�̶�� �ǹ�
		addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		//System.out.println("�ٽ� �׷��ݴϴ�");
		//g.drawLine(x1,y1,x2,y2);
		
		//����Ʈ�� ��� ��� ���� �׸���
		for( GraphicInfo info : list) {
			g.drawLine(info.getX1(), info.getY1(), info.getX2(), info.getY2());
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {	//���콺�� ������ ��
		x1 = e.getX();
		y1 = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {	//���콺���� ���� ������ ��
		x2 = e.getX();
		y2 = e.getY();
		
//�ϳ��� ���� �ϼ��ɶ� ���� ������x, ������y, ����x, ����y�� ������ �ִ� GraphicInfo ��ü���� �� ����Ʈ�� ���
		list.add(new GraphicInfo(x1, y1, x2, y2));
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
