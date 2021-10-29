package com.sist.draw;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.Color;

//JMenuItem을 눌렀을때 MyFrame클래스 자신이 이벤트처리 담당자가 되도록 하기위해 ActionListener인터페이스 구현
public class MyFrame extends JFrame implements ActionListener {
	private LinePanel lp;
	
	//저장할 파일명과 열어올 파일명을 선택할 JFileChooser를 맴버변수로 선언
	JFileChooser jfc;
	
	//색상을 선택하기 위한 다이얼로그 JColorChooser를 맴버변수로 선언
	JColorChooser jcc;
	
	public MyFrame() {
		lp = new LinePanel();
		add(lp);
		
		//JFileChooser 객체 생성
		jfc = new JFileChooser("c:/myData");
		
		//JColorChooser 객체를 생성
		jcc = new JColorChooser();
		
		//메뉴바 생성
		JMenuBar jmb =  new JMenuBar();
		
		//주메뉴 파일,그리기도구,그리기색상 생성
		JMenu mn_file = new JMenu("파일");
		JMenu mn_draw = new JMenu("그리기도구");
		JMenu mn_color = new JMenu("그리기색상");
		
		//주메뉴 파일의 부메뉴 새파일,열기,저장 생성
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

		//주메뉴 그리기색상의 부메뉴
		JMenuItem color_red = new JMenuItem("빨강");
		JMenuItem color_blue = new JMenuItem("파랑");
		JMenuItem color_green = new JMenuItem("초록");
		JMenuItem color_other = new JMenuItem("기타");
		
		//부메뉴들을 그리기색상 주메뉴에 담기
		mn_color.add(color_red);
		mn_color.add(color_blue);
		mn_color.add(color_green);
		mn_color.add(color_other);
		
		//주메뉴를 메뉴바에 담기
		jmb.add(mn_file);
		jmb.add(mn_draw);
		jmb.add(mn_color);
		
		//메뉴바를 프레임에 설정
		setJMenuBar(jmb);
		
		//각각의 JMenuItem에 대해 이벤트를 등록
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		draw_line.addActionListener(this);
		draw_rect.addActionListener(this);
		draw_oval.addActionListener(this);
		
		color_red.addActionListener(this);
		color_blue.addActionListener(this);
		color_green.addActionListener(this);
		color_other.addActionListener(this);
		
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
				System.out.println("파일 저장");
				
				//어디에 어떤이름으로 저장할지 선택하도록 JFileChooser 다이얼로그를 띄움
				int re = jfc.showSaveDialog(this);
				
				//저장하기 다이얼로그에서 저장,취소를 누를 수 있음
				//저장을 누르면 0이 반환
				if(re == 0) {
					
					//다이얼로그에서 선택한 파일 가져오기
					File file = jfc.getSelectedFile();
					
					//list객체를 통째로 파일로 출력하기 위해 ObjectOutputStream 이용
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
					
					//LinePanel 객체의 맴버변수인 list를 파일로 출력
					oos.writeObject(lp.list);
					oos.close();
				}
				
			}catch (Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
			
		}else if(cmd.equals("열기")) {
			
			//파일의 내용을 읽어 LinePanel 객체인 lp의 list에 저장
			//화면을 다시 그리기 위해 LinePanel 객체인 lp의 repaint를 호출
			try {
				System.out.println("파일 열기");
				
				int re = jfc.showOpenDialog(this);
				
				if(re == 0) {
					File file = jfc.getSelectedFile();
					
					//객체단위로 파일의 내용을 읽어들이기 위해 ObjectInputStream 객체 생성
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
					
					//파일로 데이터를 읽어들여 LinePanel 객체인 lp의 list에 담기
					lp.list = (ArrayList<GraphicInfo>)ois.readObject();
					
					//파일의 내용을 읽어와서 list에 담긴 그래픽의 정보만큼 다시 그려주기 위해 repaint 호출
					lp.repaint();
					
					//파일 닫기
					ois.close();
				}
				
			}catch (Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
			
		}else if(cmd.equals("새파일")) {
			
			try {
				
				//사용자가 그린 그래픽이 담겨있는 리스트 지우기
				lp.list.clear();
				//그래픽을 그리는 판넬을 다시 그리기
				lp.repaint();
				
			}catch (Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
			
		}else if(cmd.equals("선")) {		 //그리기도구 메뉴에 대한 처리
			lp.drawType =0;
		}else if(cmd.equals("사각형")) {
			lp.drawType =1;
		}else if(cmd.equals("원")) {
			lp.drawType =2;
		}else if(cmd.equals("빨강")){		 //그리기색상 메뉴에 대한 처리
			lp.drawColor = Color.red;    //대문자가능
		}else if(cmd.equals("파랑")){
			lp.drawColor = Color.blue;
		}else if(cmd.equals("초록")){
			lp.drawColor = Color.green;
		}else if(cmd.equals("기타")){
			//다른색상을 선택할수 있게 JColorChooser 다이얼로그를 띄움
			Color color = jcc.showDialog(this, "그리기색상", Color.red);
			if(color != null) {
				lp.drawColor = color;
			}
		}
	}
}

