package com.sist.echo03;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UDPChatClient extends JFrame implements ActionListener, Runnable{

	//��ȭ������ ����� TextArea�� �ɹ������� �����
	JTextArea jta;
	
	//��ȭ������ �Է��� TextField�� �ɹ������� �����
	JTextField jtf;
	
	//����½�Ʈ���� �ɹ������� �����
	DatagramSocket ds;
	DatagramPacket dp;
	
	public UDPChatClient(){
		
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
		
		
		
	
		//Runnable�� Thread�� ����
		Thread t = new Thread(this);
		t.start();
		
	}//end ������
	
	public static void main(String[] args) {
		DatagramSocket socket;
		DatagramPacket receiver,sender;
		InetAddress ia;
		int port;
		String ip;
		BufferedReader br;
		
		try {
			ip = args[0];
			port = Integer.parseInt(args[1]);
			
			ia = InetAddress.getByName(ip);
			socket = new DatagramSocket();
			br = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				String msg = "";
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
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

	

	}
}
