package com.sist.exam05;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class NestedVectorTable {

	public static void main(String[] args) {
		Vector<Vector<String>> list = new Vector<Vector<String>>();
		
		Vector<String> row1 = new Vector<String>();
		row1.add("홍길동");
		row1.add("서울");
		row1.add("010-1234-5678");
		
		Vector<String> row2 = new Vector<String>();
		row2.add("유관순");
		row2.add("인천");
		row2.add("010-1234-2222");
		
		Vector<String> row3 = new Vector<String>();
		row3.add("김유신");
		row3.add("제주");
		row3.add("010-1234-3333");
		
		list.add(row1);
		list.add(row2);
		list.add(row3);
		
		Vector<String> colNames = new Vector<String>();
		colNames.add("이름");
		colNames.add("주소");
		colNames.add("전화");
		
		
		JTable table = new JTable(list,colNames);  //JTable 생성 
		JScrollPane jsp = new JScrollPane(table);  //스크롤바 생성 후 테이블 넣기
		JFrame frame = new JFrame();			   //JFrame 생성
		frame.add(jsp);                            //frame에 테이블 넣은 스크롤바 넣기 
		frame.setSize(400,300);
		frame.setVisible(true);
		}
	}





