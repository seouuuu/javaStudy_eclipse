package com.sist.note;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class note extends JFrame {
	public JTextArea jta = new JTextArea();
	JFileChooser jfc = new JFileChooser("c:/myData");
	JMenuBar jmb = new JMenuBar();
	
	public note() {
		this.setTitle("note");
		this.setSize(1000,1000);
	}
	
	JMenu m_file = new JMenu("����");
	JMenu m_edit = new JMenu("����");
	
	JMenuItem file_new = new JMenuItem("������");
	JMenuItem file_open = new JMenuItem("����");
	JMenuItem file_save = new JMenuItem("����");
	
	
	
}
