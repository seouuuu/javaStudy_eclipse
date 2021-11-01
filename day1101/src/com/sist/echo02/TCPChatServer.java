package com.sist.echo02;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

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
				
				//���� ��ü�� ���� �����͸� �ְ���� ��Ʈ�� ����
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				//����� Ŭ���̾�Ʈ�� ����Ͽ� �����͸� �ְ�ޱ� ���� �ݺ��� �̿�
				while(true) {
					//Ŭ���̾�Ʈ�κ��� �����͸� ����
					is.read(data);
					String msg = new String(data);
					System.out.println("���ŵ� ������:"+msg.trim());
					
					//Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� �״�� �޾Ƹ���
					os.write(data);
					
					//������ ���ŵ� �����͸� ���� �迭�� �����
					Arrays.fill(data, (byte)0);
				}
			}
		}catch (Exception e) {
			
		}

	}

}
