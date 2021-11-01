package com.sist.note;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

//부메뉴를 눌렀을때 이벤트처리를 위해 ActionListener인터페이스 구현
public class SistNote extends JFrame implements ActionListener, KeyListener {
	
	//메모장의 입출력을 위하여 여러줄의 문장을 입력할수 있는 JTextArea를 맴버변수로 선언
	JTextArea jta;
	
	//저장할 파일이름과 열어올 파일이름을 선택하기 위한 JFileChooser를 맴버변수로 선언
	JFileChooser jfc;
	
	String fileName = "제목없음";
	
	//이미 파일명이 있을 경우 물어보지 않고 이 파일에 저장하도록 하기 위해 File객체를 멤버변수로 만듬
	File file = null; // 안해도 기본값 null
	
	
	//메모장의 내용 변경이 있는지 상태를 저장하기 위한 변수 선언
	boolean isNew;
	
	//생성자에서 JTextArea객체 생성 후 프레임에 담기
	public SistNote(){
		jta = new JTextArea();
		
		//isNew에 기본값을 false 설정
		isNew = false;
		
		//JFileChooser 객체를 생성
		jfc = new JFileChooser("c:/myData");
		
		//add(jta);
		//TextArea를 바로 프레임에 담으면 화면을 벗어난 글자들이 보이지 않음
		//스크롤을 자동으로 만들어주는 JScrollPane으로 감싸서 프레임에 담기
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp);
		
		//메뉴 만들기
		//메뉴바 객체 생성
		JMenuBar jmb = new JMenuBar();
		
		//주메뉴 생성
		JMenu mn_file = new JMenu("파일");
		
		//부메뉴 만들기
		JMenuItem file_new = new JMenuItem("새파일"); 
		JMenuItem file_open = new JMenuItem("열기"); 
		JMenuItem file_save = new JMenuItem("저장"); 
		
		//부메뉴들 주메뉴에 담기
		mn_file.add(file_new);
		mn_file.add(file_open);
		mn_file.add(file_save);
		
		//주메뉴 파일을 메뉴바에 담기
		jmb.add(mn_file);
		
		//프레임에 메뉴바 설정
		setJMenuBar(jmb); //this.setJMenuBar(jmb);도 가능
		
		//부메뉴 메뉴를 눌렀을때 일을 수행하도록 이벤트 등록
		//매개변수 이벤트처리담당객체를 전달해야하는데 이 클래스(SistNote) 자신이 처리하도록 this 전달
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		
		//TextArea에 키이벤트를 등록
		jta.addKeyListener(this);
		
		//프레임의 크기를 설정하고 프레임을 보여주도록 설정
		setSize(800,600);
		setVisible(true);
		setTitle(fileName);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//선택된 메뉴를 파악하기 위해 ActionEvent의 getActionCommand 메소드를 이용하여 메뉴의 "글자"가져옴
		String cmd = e.getActionCommand();
		
		//선택된 메뉴에 따라 각각의 일처리를 하도록 함
		if(cmd.equals("새파일")) {
			
			if(isNew == true) {
				int re = JOptionPane.showConfirmDialog(this, "저장하시겠습니까?");
				//System.out.println("re:"+ re);
				//re=0 : 저장하고 새파일 처리
				//re=1 : 저장 안하고 새파일 처리
				//re=2 : 새파일 취소
				switch(re) {
				case 0:saveFile();
				case 1:
					jta.setText("");
					fileName = "제목없음";
					setTitle(fileName);
					isNew = false;
					file = null;
					break;
				case 2:return;
				}
			}else {
				jta.setText("");
				fileName = "제목없음";
				setTitle(fileName);
				isNew = false;
				file = null;
			}
			
			
			
		}else if(cmd.equals("열기")) {
			try {
				//열기메뉴를 누르면 어디에 있는 어떤 파일을 열어올지 선택하기 위한 다이얼로그 띄움
				int re = jfc.showOpenDialog(this);
				
				//다이얼로그에서 취소가 아닌 열기를 눌렀을때 파일의 내용을 읽어오는 처리
				if(re == 0) {
					//선택한 파일정보 가져오기
					//열어온 파일을 멤버변수 file에 저장
					file = jfc.getSelectedFile();
					
					//파일의 내용을 컴퓨터메모리로 읽어들이기 위한 스트림 생성
					FileReader fr = new FileReader(file);
					
					//파일의 모든 내용을 담기 위한 문자열 변수 만들기
					//파일로부터 한글자씩 읽어와서 누적하기 위해 초기화
					String data = "";
					
					//파일로부터 한글자씩 읽기위한 변수 만들기
					int ch;
					
					//반복문을 이용하여 파일의 끝이 아닐동안 한글자씩 읽어들이기
					while(true) {
						//파일로부터 한글자씩 읽어들임
						//문자에 해당하는 정수값 반환
						//만약 더이상 읽어들일 내용이 없고 파일의 끝에 도달하면 -1 반환
						ch = fr.read();
						
						//파일로부터 더이상 읽어들일 내용이 없으면 반복문 탈출
						if( ch == -1 ) {
							break;
						}
						
						//파일의 끝이 아니라면 읽어들인 문자의 숫자를 다시 문자로 변환하여 data에 누적
						data = data + (char)ch;
					}
					//파일의 내용을 모두 읽어들인 다음 while을 탈출
					//while을 탈출했을때 파일의 모든 내용은 String 변수 data에 담겨져 있음
					//data의 내용을 TextArea에 설정
					jta.setText(data);
					
					//파일사용 완료 후 닫기
                	fr.close();
					
					JOptionPane.showMessageDialog(this, "파일을 읽어왔습니다.");
					
					//읽어온 파일의 정보를 담고있는 File객체로부터 파일명을 뽑아 fileName에 담기
					//fileName = file.getName();   확장자도 표시됨
					fileName = file.getName();
					fileName = fileName.substring(0,fileName.indexOf("."));
					
					//파일명을 프레임의 제목표시줄로 설정
					setTitle(fileName);
				
				}
			}catch (Exception ex) {
				System.out.println("예외발생:"+ex.getMessage());
			}
			
			isNew = false;
			
		}else if(cmd.equals("저장")) {
			saveFile();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		isNew = true;
	}
	
	public void saveFile() {
		//어디에 어떤파일이름을 저장할 것인지 선택하도록 다이얼로그를 띄움
		//매개변수 this는 이 다이얼로그를 어떤프레임위에서 띄울것인지 전달
		//현재 프레임 SistNote에 띄우라는 의미로 객체자신을 의미하는 this 전달
		//showSaveDialog에서 저장/취소 선택 가능
		//저장을 누르면 0을 반환, 취소를 누르면 1을 반환
		//반환하는 값은 변수에 담아 그 값에 따라 그 다음 일처리를 다르게 할 수 있음
		
		//파일이 없다면 파일을 선택하기 위한 다이얼로그를 띄우고 이미 파일이 있다면 그 이름으로 저장
		
		int re = 0;
		//이미 파일이름이 있는 상태에서 file이 null이 아닌 상태이면 저장을 누르면 무조건 저장해야함
		//처음 파일을 저장하면 file이 null 인 상태에서 저장을 누르면 파일을 선택하는 다이얼로그에서 취소를
		//누르지 않고 저장을 눌렀을때만 저장하도록 처리
		//동시에 처리하기 위해 re에 기본값 0을 설정
		//이미 파일이 있으면 다음의 if를 만나지 않아 re는 그대로 0유지
		//파일이 없는 상태면 if를 만나서 띄워진 다이얼로그에서 취소를 누르면 re = 1이 됨, 저장처리 안함
		if(file == null) {
			re = jfc.showSaveDialog(this);
			if(re == 0) {
				file = jfc.getSelectedFile();
			}
		}
		
		//저장하기 다이얼로그에 저장을 눌렀을때 파일저장을 위한 명령어들이 동작하도록 함
		if(re == 0) {
			//다이얼로그에서 선택한 파일 가져오기
            File file = jfc.getSelectedFile();
            
            //선택한 파일에 textArea에 쓰여진 내용을 출력하기 위한 스트림 생성
            //문자단위의 출력을 위한 Writer의 후손인 FileWriter 이용
            //입출력과 관련된 모든 생성자와 메소드들은 예외를 포함
            //그 예외들은 RuntimeException의 후손들이 아니므로 반드시 예외처리 해야함
            try {
            	FileWriter fw = new FileWriter(file);
            	
            	//textArea의 내용 읽어와서 파일로 출력
            	fw.write(jta.getText());
            	
            	//파일사용 완료 후 닫기
            	fw.close();
            	
            	//사용자에게 알려줄 내용을 콘솔이 아닌 다이얼로그를 띄움
            	JOptionPane.showMessageDialog(this, "파일을 저장하였습니다.");
            	
            	//저장한 파일의 정보를 가진 객체 File file로 부터 파일이름을 가져와 fileName에 담기
            	//fileName = file.getName();   확장자도 표시됨
				fileName = file.getName();
				fileName = fileName.substring(0,fileName.indexOf("."));
				
				//파일명을 프레임의 제목표시줄로 설정
				setTitle(fileName);
			
            }catch (Exception ex) {	//예외변수이름과 이벤트변수이름이 달라야함
				System.out.println("예외발생:"+ex.getMessage());
			}
            
        	isNew = false;
		}
	
	}
}
