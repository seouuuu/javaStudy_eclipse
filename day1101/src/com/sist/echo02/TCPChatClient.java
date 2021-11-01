package com.sist.echo02;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TCPChatClient extends JFrame implements ActionListener, Runnable{

	//��ȭ������ ����� TextArea�� �ɹ������� �����
	JTextArea jta;
	
	//��ȭ������ �Է��� TextField�� �ɹ������� �����
	JTextField jtf;
	
	//����½�Ʈ���� �ɹ������� �����
	InputStream is;
	OutputStream os;
	
	public TCPChatClient(){
		
		//�ɹ����� TextArea�� TextField�� ����
		jta = new JTextArea();
		jtf = new JTextField(50);
		
		//������ ���� ��ư ����
		JButton btn = new JButton("����");
		
		//��ư�� �̺�Ʈ ���
		btn.addActionListener(this);
		
		//TextField�� ��ư�� ������� �г� ����
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//TextArea�� Scrollpane���� ���α�
		JScrollPane jsp = new JScrollPane(jta);
		
		//�������� ��� TextArea�� ���ΰ� �ִ� Scrollpane�� ���
		add(jsp,BorderLayout.CENTER);
		
		//TextField�� ��ư�� ��� �ִ� �г��� �������� �Ʒ��� ���
		add(p,BorderLayout.SOUTH);
		
		//�������� ũ�� ����
		setSize(800,600);
		
		//�������� ȭ�鿡 ���̵��� ����
		setVisible(true);
		
		try {
			//����� ���� ������ ������ ��û
			Socket socket = new Socket("172.30.1.4",9003);
			
			//������� ���� ��Ʈ�� ����
			is = socket.getInputStream();
			os = socket.getOutputStream();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		//Runnable�� Thread�� ����
		Thread t = new Thread(this);
		t.start();
		
	}//end ������
	
	public static void main(String[] args) {
		new TCPChatClient();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			//����ڰ� �Է��� TextField�� ������ ������ ������
			//OutputStream void write(byte[] b) �޼ҵ� �̿�
			byte []data = jtf.getText().getBytes();
			os.write(data);
			
			//�޼��� �����ϰ� ���� �޼��� �Է��� ���� TextField�� ������ �����
			jtf.setText("");
			
		}catch(Exception ex){
			System.out.println("���ܹ߻�:"+ex.getMessage());
		}
	}

	//�����κ��� ���ŵ� �����͸� ��� �޵��� ��
	@Override
	public void run() {
		
		byte []data = new byte[100];
		while(true) {
			try {
				is.read(data);
				String msg = new String(data);
				msg = msg.trim();
				jta.append(msg+"\n");
				
			}catch (Exception e) {
				
			}
		}
	}
}
