package com.sist.draw02;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	private LinePanel lp;

	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		setSize(600,400);
		setVisible(true);
		setTitle("���׸���");
	}
}
