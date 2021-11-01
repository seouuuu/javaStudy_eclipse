package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPReceiver {
	public static void main(String[] args) {
		
		//�����͸� �ְ�ޱ� ���� DatagramSocket��ü�� ����
		//DatagramSocket(int port)
		
		try {
			DatagramSocket socket = new DatagramSocket(9002);
			
			//�������� �����͸� ������� byte�� �迭 ����
			byte []data = new byte[100];
			
			//Sender�� �������� �����͸� �ޱ����� DatagramPacket��ü ����
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			//Sender�� �������� �����͸� ��� �ޱ����� ���ѹݺ������� ǥ��
			while(true) {
				//DatagramSocket�� receive�޼ҵ带 ���� �����͸� ����
				socket.receive(packet);
				
				//��¥ �޾��� �����ʹ� byte���� �迭��(��Ŷ�� ���鶧 �� �迭)�� data�� ����� ����
				//�̰��� String�������� �̿��Ͽ� ���ڿ��� ����
				String msg = new String(data);
				System.out.println("���ŵȵ�����: "+msg);
				
				//���� ���ŵǴ� �����͸� ���� byte�� �迭 data�� �������
				Arrays.fill(data, (byte)0);
			}
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�: "+e.getMessage());
		}
	}
}
