package com.sist.draw06;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

//JMenuItem을 눌렀을때 MyFrame클래스 자신이 이벤트처리 담당자가 되도록 하기위해 ActionListener인터페이스 구현
public class MyFrame extends JFrame implements ActionListener {
	private LinePanel lp;

	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		
		//메뉴바 생성
		JMenuBar jmb =  new JMenuBar();
		
		//주메뉴 파일,그리기도구 생성
		JMenu mn_file = new JMenu("파일");
		JMenu mn_draw = new JMenu("그리기도구");
		
		//부메뉴 새파일,열기,저장 생성
		JMenuItem file_new = new JMenuItem("새파일");
		JMenuItem file_open = new JMenuItem("열기");
		JMenuItem file_save = new JMenuItem("저장");
		
		//부메뉴들을 주메뉴에 담기
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		//주메뉴 그리기도구에 담길 부메뉴 선,사각형,원 생성
		JMenuItem draw_line = new JMenuItem("선");
		JMenuItem draw_rect = new JMenuItem("사각형");
		JMenuItem draw_oval = new JMenuItem("원");
		
		//부메뉴들을 그리기도구 주메뉴에 담기
		mn_draw.add(draw_line);
		mn_draw.add(draw_rect);
		mn_draw.add(draw_oval);

		//주메뉴를 메뉴바에 담기
		jmb.add(mn_file);
		jmb.add(mn_draw);
		
		//메뉴바를 프레임에 설정
		setJMenuBar(jmb);
		
		//각각의 JMenuItem에 대해 이벤트를 등록
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		draw_line.addActionListener(this);
		draw_rect.addActionListener(this);
		draw_oval.addActionListener(this);
		
		setSize(600,400);
		setVisible(true);
		setTitle("선그리기");
		
	}
	
	//각각의 JMenuItem 누르면 actionPerformed메소드 동작
	@Override
	public void actionPerformed(ActionEvent e) {
	//JMenuItem 중 어떤 메뉴가 눌러졌는지 파악하기 위해 매개변수 ActionEvent의 getActionCommand()이용
		String cmd = e.getActionCommand();
		//System.out.println(cmd + "가(이) 눌러짐");
		
		if(cmd.equals("저장")) {
			try {
				//현재 화면에 그려진 모든 선들을 파일로 저장("c:/myData/data.pan")
				//현재 화면에 그려진 모든 선들의 정보는 LinePanel 객체인 lp의 list에 담겨져있음
				//list객체를 통째로 파일로 출력하기 위해 ObjectOutputStream 이용
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/myData/data.pan"));
				
				//LinePanel 객체의 맴버변수인 list를 파일로 출력
				oos.writeObject(lp.list);
				
				oos.close();
			}catch (Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
			
		}else if(cmd.equals("열기")) {
			//"c:/myData/data.pan" 파일의 내용을 읽어 LinePanel 객체인 lp의 list에 저장
			//화면을 다시 그리기 위해 LinePanel 객체인 lp의 repaint를 호출
			try {
				//객체단위로 파일의 내용을 읽어들이기 위해 ObjectInputStream 객체 생성
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/myData/data.pan"));
				
				//파일로 데이터를 읽어들여 LinePanel 객체인 lp의 list에 담기
				lp.list = (ArrayList<GraphicInfo>)ois.readObject();
				
				//파일의 내용을 읽어와서 list에 담긴 그래픽의 정보만큼 다시 그려주기 위해 repaint 호출
				lp.repaint();
				
				//파일 닫기
				ois.close();
				
			}catch (Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
			
		}else if(cmd.equals("새파일")) {
			System.out.println("새파일의 처리");
		}else if(cmd.equals("선")) {
			lp.drawType =0;
		}else if(cmd.equals("사각형")) {
			lp.drawType =1;
		}else if(cmd.equals("원")) {
			lp.drawType =2;
		}
	}
}

