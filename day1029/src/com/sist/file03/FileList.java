package com.sist.file03;

import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SortingFocusTraversalPolicy;

import java.awt.BorderLayout;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;

public class FileList extends JFrame implements MouseListener,ActionListener {
	JList<Vector<String>> list;
	JTextArea jta;
	String path = "c:/myData";
	
	//JList의 데이터를 위한 벡터 선언
	Vector vector;
	
	public FileList() {
		
		//벡터 생성
		vector = new Vector<String>();
		
		//C:\javaStudy\day1025 에 있는 모든 파일목록으로 JList 만들기
		
		//디렉토리(폴더)도 File객체로 만들기
		File dir = new File(path);
		
		//디렉토리안에 있는 모든 파일이름과 디렉토리이름의 목록을 배열로 가지고옴
		String []arr = dir.list();
		
		//디렉토리의 파일목록을 벡터에 담기
		for(String str:arr) {
			vector.add(str);
		}
		
		//벡터의 내용으로 JList를 만듬
		list = new JList<Vector<String>>(vector);
		
		//JList에 이벤트등록
		list.addMouseListener(this);
		
		//JScrollPane으로 감싸서 담기
		//add(list);
		JScrollPane jsp_list = new JScrollPane(list);
		
		jta = new JTextArea();
		JScrollPane jsp_area = new JScrollPane(jta);
		
		//삭제를 위한 버튼
		JButton btn_delete = new JButton("삭제");
		
		//버튼의 이벤트 담기
		btn_delete.addActionListener(this);
		
		//JList를 담은 jsp_list는 프레임의 왼쪽
		add(jsp_list, BorderLayout.WEST);
		
		//TestArea를 담은 jsp_area는 프레임의 중앙
		add(jsp_area, BorderLayout.CENTER);
		
		//삭제를 위한 버튼을 프레임의 아래쪽
		add(btn_delete, BorderLayout.SOUTH);
		
		setSize(800,600);
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//JList에서 선택한 파일이름을 가지고오기
		int idx = list.getSelectedIndex();
		String fileName = (String)vector.get(idx);
		System.out.println(fileName);
		
		try {
			//선택한 파일이름과 파일이 있는 경로를 합쳐서 File객체 혹은 String으로 만들어
			//파일을 읽기위한 스트림을 생성
			FileReader fr = new FileReader(path+"/"+fileName);
			
			//파일의 내용을 모두 읽어와 누적하기 위한 문자열 변수를 만들고 ""으로 초기화
			String data ="";
			
			//파일로부터 한글자씩 읽어들이기 위한 변수 선언
			int ch;
			
			//반복문을 이용하여 파일의 내용을 모두 읽어오기
			while(true) {
				//파일로부터 한글자씩 읽기
				ch = fr.read();
				
				//파일의 끝에 도달하면 읽어온 값은 -1
				if(ch == -1) {
					break;
				}
				
				//파일의 끝이 아니면 읽어온 문자를 data에 누적
				data += (char)ch;
			}
			//현재 JList에서 선택한 파일의 내용을 다 읽어들이면 while을 탈출
			//현재 선택한 파일의 모든 내용은 문자열 변수 data에 저장되어 있는 것을 TestArea에 출력
			jta.setText(data);
			
			//사용한 파일 닫기
			fr.close();
			
		}catch (Exception ex) {
			System.out.println("예외발생:"+ex.getMessage());
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//삭제하기 위해 삭제할 파일의 File 객체 만들기
		File file = new File(path + "/"+ list.getSelectedValue());
		
		//파일 삭제
		file.delete();
		
		//TextArea 지우기
		jta.setText("");
		
		//c:myData 폴더의 파일목록을 다시 읽어와서 Vector 내용을 바꾸고 JList를 다시그리도록 요청
		File dir = new File(path);
		String []arr = dir.list();
		
		//벡터를 지우고 다시 읽어온 파일 목록을 담기
		vector.clear();
		for(String f:arr) {
			vector.add(f);
		}
		
		//JList의 모양을 바뀐 벡터의 내용으로 다시 그리도록 요청
		list.updateUI();
		
		JOptionPane.showMessageDialog(this, "선택한 파일을 삭제하였습니다.");
	}
}
