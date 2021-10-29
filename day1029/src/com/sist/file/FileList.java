package com.sist.file;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class FileList extends JFrame {
	JList<String> list;
	
	public FileList() {
		//JList에 목록으로 사용할 배열을 만들기
		String []arr = {"사과","포도","수박","딸기","포도","수박","딸기","포도","수박","딸기","포도","수박","딸기"};
		list = new JList<String>(arr);
		
		//JScrollPane으로 감싸서 담기
		//add(list);
		JScrollPane jsp_list = new JScrollPane(list);
		add(jsp_list);
		
		setSize(400,300);
		setVisible(true);
		
	}
}
