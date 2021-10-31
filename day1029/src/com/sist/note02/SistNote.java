package com.sist.note02;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class SistNote extends JFrame implements ActionListener{
	
	JTextArea jta;
	JFileChooser jfc;
	String fileName = "�������";
	
	public SistNote(){
		jta = new JTextArea();
		jfc = new JFileChooser("c:/myData");
		
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp);
	
		JMenuBar jmb = new JMenuBar();
		JMenu mn_file = new JMenu("����");
	
		JMenuItem file_new = new JMenuItem("������"); 
		JMenuItem file_open = new JMenuItem("����"); 
		JMenuItem file_save = new JMenuItem("����"); 
		
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		jmb.add(mn_file);
		setJMenuBar(jmb); 
	
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
	
		setSize(800,600);
		setVisible(true);
		setTitle(fileName);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals("������")) {
			File file = jfc.getSelectedFile();
			try {
				JOptionPane.showMessageDialog(this, "�����Ͻðڽ��ϱ�?");
				int re = jfc.showSaveDialog(this);
				System.out.println(re);
				if(re == 0) {
					Save();
				}
				
	        	jta.setText("");
				setTitle("�������");
				
			}catch (Exception ex) {
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
	
		}else if(cmd.equals("����")) {
			JOptionPane.showMessageDialog(this, "�����Ͻðڽ��ϱ�?");
			int re = jfc.showSaveDialog(this);
			if(re == 0) {
				Save();
			}
			
			Open();
			
		}else if(cmd.equals("����")) {
			
			Save();
		}
	}
	
	public void Open() {
		try {
			int re = jfc.showOpenDialog(this);
			if(re == 0) {
				File file = jfc.getSelectedFile();
				FileReader fr = new FileReader(file);
				String data = "";
				int ch;
				while(true) {
					ch = fr.read();
					if( ch == -1 ) {
						break;
					}
					data = data + (char)ch;
				}
				jta.setText(data);
	        	fr.close();
				JOptionPane.showMessageDialog(this, "������ �о�Խ��ϴ�.");
				fileName = file.getName();
				fileName = fileName.substring(0,fileName.indexOf("."));
				setTitle(fileName);
			}
		}catch (Exception ex) {
			System.out.println("���ܹ߻�:"+ex.getMessage());
		}
	}

	public void Save() {
		int re = jfc.showSaveDialog(this);
		if(re == 0) {
	        File file = jfc.getSelectedFile();
	        try {
	            	FileWriter fw = new FileWriter(file);
	            	fw.write(jta.getText());
	            	fw.close();
	            	JOptionPane.showMessageDialog(this, "������ �����Ͽ����ϴ�.");
					fileName = file.getName();
					fileName = fileName.substring(0,fileName.indexOf("."));
					setTitle(fileName);
	        }catch (Exception ex) {	
				System.out.println("���ܹ߻�:"+ex.getMessage());
			}
		}
    }
}
