package com.sist.tcp;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

//������ �ѹ��� �������� Ŭ���̾�Ʈ�� ��ȭ�� �����ϵ���(�޾Ƹ�) �ϱ� ���� 
//Ŭ���̾�Ʈ�� ��� ��ȭ�� �ְ�޴� ����� ������� ����

class ServerThread extends Thread{
	
	//��û�� Ŭ���̾�Ʈ�� ����� ������ �ɹ������� ����
	Socket socket;
	
	//����� Ŭ���̾�Ʈ�� �����͸� �ְ���� ��Ʈ���� ����
	InputStream is;
	OutputStream os;
	
	//������ �����Ͱ� ��� �迭�� ����
	byte []data = new byte[100];
	
	//��ü������ Ŭ���̾�Ʈ�� ����� ������ �Ű������� ���޹޾� �ɹ������� ��� ��Ʈ���� ����
	public ServerThread(Socket socket) {
		this.socket = socket;
		try {
			is = this.socket.getInputStream();
			os = this.socket.getOutputStream();
		}catch (Exception e) {
			System.out.println("���ܹ߻�:"+e.getMessage());
		}
	}
	
	public void run() {
		//����� Ŭ���̾�Ʈ�� ����Ͽ� �����͸� �ְ�ޱ� ���� �ݺ��� �̿�
		while(true) {
			try {
				//Ŭ���̾�Ʈ�κ��� �����͸� ����
				is.read(data);
				String msg = new String(data);
				System.out.println("���ŵ� ������:"+msg.trim());
				
				//Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� �״�� �޾Ƹ���
				os.write(data);
				
				//������ ���ŵ� �����͸� ���� �迭�� �����
				Arrays.fill(data, (byte)0);
			}catch (Exception e) {
				System.out.println("���ܹ߻�:"+e.getMessage());
			}
		}
	}
}


public class TCPChatServer {

	public static void main(String[] args) {
		
		//Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� ��� ���� byte�� �迭 �����
		byte []data = new byte[100];
		
		try {
			//1. ServerSocket�� ���� ���� ����
			ServerSocket server = new ServerSocket(9003);
			
			while(true) {	//���Ѵ�� ���·� Ŭ���̾�Ʈ�� ������ ��ٸ�
				
				//Ŭ���̾�Ʈ�� ��û ����
				Socket socket = server.accept();
			
				//����� Ŭ���̾�Ʈ�� ��� ��ȭ �ϱ� ���� �����尴ü ����, ����
				ServerThread thread = new ServerThread(socket);
				thread.start();
				
				
			}
		}catch (Exception e) {
			
		}

	}

}
