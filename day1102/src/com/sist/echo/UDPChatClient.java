package com.sist.echo;

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
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UDPChatClient extends JFrame implements ActionListener{

	//UDP������� �����͸� �ְ�ޱ� ���� DatagramSocket�� DatagramPacket�� �ɹ������� ����
		DatagramSocket socket;
		DatagramPacket packet;
		
	//��ȭ������ ǥ���ϱ� ���� TextArea�� �ɹ������� ����
	JTextArea jta;
	
	//��ȭ������ �Է��ϱ� ���� TextField�� �ɹ������� ����
	JTextField jtf;
	
	public UDPChatClient() {
		//�ɹ������� ����
		jta = new JTextArea();
		jtf = new JTextField(50);	//�ѹ��� �Է��� �� �ִ� ���ڼ�
		
		//������ ���� ��ư ����
		JButton btn = new JButton("����");
		
		//TextFiled�� ��ư�� ���� �г� ����
		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);
		
		//TextArea�� ��ũ�� �� ��ü ����
		JScrollPane jsp = new JScrollPane(jta);
		
		//�������� ����� TextArea�� ���ΰ� �ִ� ��ũ���� ���
		add(jsp,BorderLayout.CENTER);
		
		//�������� �Ʒ��� TextField�� ��ư�� ��� �ִ� �г��� ���
		add(p,BorderLayout.SOUTH);
		
		//�������� ũ�⸦ ����
		setSize(800,600);
		
		//ȭ�鿡 �����ֵ��� ����
		setVisible(true);
		
		try {
			//�����͸� �ְ�ޱ� ���� �޼ҵ带 ������ �ִ� DatagramSocket��ü ����
			socket = new DatagramSocket();
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
		
		//���۹�ư�� �̺�Ʈ�� ����Ͽ� TextField�� �Է��� ������ ������ ����
		btn.addActionListener(this);
		
		//�����κ��� �����͸� ��� �����ϱ� ���� ������Ŭ������ innerŬ������ ����
		class ClientThread implements Runnable{
			DatagramPacket packet;
			byte []data = new byte[100];
			
			public void run() {
				
				//�����͸� �����ϱ� ���� ��Ŷ ����
				packet = new DatagramPacket(data,data.length);
				
				//����Ͽ� �����κ��� �����͸� ����
				while(true) {
					try {
						//�����͸� ����
						socket.receive(packet);
						
						//�����κ��� ���ŵ� �����Ͱ� �ִ� �迭�� ������ ���ڿ��� �����
						String msg = new String(data);
						
						//���ŵ� ���ڿ��� TextArea�� �߰�
						jta.append(msg.trim() + "\n");
						
						//���������� ������ ���� �迭�� ������
						Arrays.fill(data, (byte)0);
						
					}catch (Exception e) {
						System.out.println("���ܹ߻�:"+e.getMessage());
					}
				}//end while
				
			}//end run
		}//end innerclass
		
		//������ ��ü�� �����ϰ� ������ ����
		new Thread(new ClientThread()).start();
		
	}//end ������

	
	public static void main(String[] args) {
		new UDPChatClient();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
		//����ڰ� �Է��� ��ȭ������ �ִ� TextField�� ���ڿ� ������ ����
		String msg = jtf.getText();
		
		//UDP ������� ������ �������� ��Ŷ �����ؾ� ��. ���ڿ��� byte[] �迭�� ������ ��
		byte []data = msg.getBytes();
		
		//InetAddress ��ü ����
		InetAddress addr = InetAddress.getByName("localhost");
		
		int port = 9005;
		
		//�����͸� ���� ��Ŷ ����
		packet = new DatagramPacket(data,data.length,addr,port);
		
		//������ ������ ����
		socket.send(packet);
		
		}catch (Exception ex) {
			System.out.println("���ܹ߻�:"+ex.getMessage());
		}
	}

}
