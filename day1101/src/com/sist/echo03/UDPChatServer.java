package com.sist.echo03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPChatServer {

	public static void main(String[] args) {
		
		DatagramSocket socket;
		DatagramPacket receiver, sender;
		int port = 9005;
		
		//Ŭ���̾�Ʈ�κ��� ���ŵ� �����͸� ��� ���� byte�� �迭 �����
		byte []data = new byte[100];
		
		try {
			//1. ServerSocket�� ���� ���� ����
			socket = new DatagramSocket(port);
			
			while(true) {	//���Ѵ�� ���·� Ŭ���̾�Ʈ�� ������ ��ٸ�
				
				receiver = new DatagramPacket(data,data.length);
				
				socket.receive(receiver);
				
				//����� Ŭ���̾�Ʈ�� ����Ͽ� �����͸� �ְ�ޱ� ���� �ݺ��� �̿�
				while(true) {
					
					String msg = new String(receiver.getData(),0,receiver.getLength());
					System.out.println("���ŵ� ������:"+msg.trim());
					
					sender = new DatagramPacket(receiver.getData(), receiver.getData().length,receiver.getAddress(),receiver.getPort());
					
					socket.send(sender);
					
					//������ ���ŵ� �����͸� ���� �迭�� �����
					Arrays.fill(data, (byte)0);
				}
			}
		}catch (Exception e) {
			
		}
	}
}
