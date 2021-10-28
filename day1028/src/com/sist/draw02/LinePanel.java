package com.sist.draw02;

import java.awt.Graphics;

import javax.swing.JPanel;

public class LinePanel extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		
		//g.drawLine(10,10,70,70);
		
		//변수로 만들어도 가능
	    int x1 = 10;
		int y1 = 10;
		int x2 = 300;
		int y2 = 300;
		g.drawLine(x1,y1,x2,y2);
		
	}
	
}
