//java UDPSender 172.30.1.4 �ȳ�
//java UDPSender 172.30.1.4 �ݰ����ϴ�

package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender {
	public static void main(String[] args) {
		
		String ip = args[0];
		String msg = args[1];
		
		
		//UDP ��Ŀ��� �����͸� �ְ� �ޱ� ���ؼ��� DatagramSocket�� �ʿ�
		//DatagramSocket(int port)
		try {
			DatagramSocket socket = new DatagramSocket();
			
			//�������� �ּ� ip�� ������ InetAddress��ü ����
			InetAddress addr = InetAddress.getByName(ip);
			
			//�����ϰ����ϴ� ���ڿ� msg�� byte�� �迭�� ����
			byte[]data = msg.getBytes();
			
			//UDP����� ���������۴��� ��Ŷ ����
			DatagramPacket packet = new DatagramPacket(data, data.length, addr, 9002);
			
			//DatagramSocket�� send�޼ҵ带 ���� �����͸� ����
			socket.send(packet);
			
			//���� �ݱ�
			socket.close();
			
			
		}catch (Exception e) {
			System.out.println("���ܹ߻�: "+e.getMessage());
		}
	}
}
