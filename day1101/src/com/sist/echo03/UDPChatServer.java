package com.sist.echo03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPChatServer {

	public static void main(String[] args) {
		
		DatagramSocket socket;
		DatagramPacket receiver, sender;
		int port = 9005;
		
		//클라이언트로부터 수신된 데이터를 담기 위한 byte의 배열 만들기
		byte []data = new byte[100];
		
		try {
			//1. ServerSocket을 통해 서버 가동
			socket = new DatagramSocket(port);
			
			while(true) {	//무한대기 상태로 클라이언트의 접속을 기다림
				
				receiver = new DatagramPacket(data,data.length);
				
				socket.receive(receiver);
				
				//연결된 클라이언트와 계속하여 데이터를 주고받기 위해 반복문 이용
				while(true) {
					
					String msg = new String(receiver.getData(),0,receiver.getLength());
					System.out.println("수신된 데이터:"+msg.trim());
					
					sender = new DatagramPacket(receiver.getData(), receiver.getData().length,receiver.getAddress(),receiver.getPort());
					
					socket.send(sender);
					
					//다음에 수신될 데이터를 위해 배열을 비워줌
					Arrays.fill(data, (byte)0);
				}
			}
		}catch (Exception e) {
			
		}
	}
}
