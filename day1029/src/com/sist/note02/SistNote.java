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
	String fileName = "제목없음";
	
	public SistNote(){
		jta = new JTextArea();
		jfc = new JFileChooser("c:/myData");
		
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp);
	
		JMenuBar jmb = new JMenuBar();
		JMenu mn_file = new JMenu("파일");
	
		JMenuItem file_new = new JMenuItem("새파일"); 
		JMenuItem file_open = new JMenuItem("열기"); 
		JMenuItem file_save = new JMenuItem("저장"); 
		
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
		
		if(cmd.equals("새파일")) {
			File file = jfc.getSelectedFile();
			try {
				JOptionPane.showMessageDialog(this, "저장하시겠습니까?");
				int re = jfc.showSaveDialog(this);
				System.out.println(re);
				if(re == 0) {
					Save();
				}
				
	        	jta.setText("");
				setTitle("제목없음");
				
			}catch (Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
	
		}else if(cmd.equals("열기")) {
			JOptionPane.showMessageDialog(this, "저장하시겠습니까?");
			int re = jfc.showSaveDialog(this);
			if(re == 0) {
				Save();
			}
			
			Open();
			
		}else if(cmd.equals("저장")) {
			
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
				JOptionPane.showMessageDialog(this, "파일을 읽어왔습니다.");
				fileName = file.getName();
				fileName = fileName.substring(0,fileName.indexOf("."));
				setTitle(fileName);
			}
		}catch (Exception ex) {
			System.out.println("예외발생:"+ex.getMessage());
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
	            	JOptionPane.showMessageDialog(this, "파일을 저장하였습니다.");
					fileName = file.getName();
					fileName = fileName.substring(0,fileName.indexOf("."));
					setTitle(fileName);
	        }catch (Exception ex) {	
				System.out.println("예외발생:"+ex.getMessage());
			}
		}
    }
}
