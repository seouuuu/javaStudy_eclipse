package com.sist.draw01;

import java.awt.Graphics;

import javax.swing.JPanel;

public class LinePanel extends JPanel {

	@Override
	protected void paintComponent(Graphics g) {
		
		//drawLine(int x1, int y1, int x2, int y2)  - (x1,y1)°ú (x2,y2)À» ÀÕ´Â ¼±
		g.drawLine(10,10,110,10);
	}
	
}
