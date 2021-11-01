package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPReceiver {
	public static void main(String[] args) {
		
		//데이터를 주고받기 위해 DatagramSocket객체를 생성
		//DatagramSocket(int port)
		
		try {
			DatagramSocket socket = new DatagramSocket(9002);
			
			//보내오는 데이터를 담기위한 byte의 배열 생성
			byte []data = new byte[100];
			
			//Sender가 보내오는 데이터를 받기위해 DatagramPacket객체 생성
			DatagramPacket packet = new DatagramPacket(data, data.length);
			
			//Sender가 보내오는 데이터를 계속 받기위해 무한반복문으로 표현
			while(true) {
				//DatagramSocket의 receive메소드를 통해 데이터를 받음
				socket.receive(packet);
				
				//진짜 받아진 데이터는 byte형의 배열인(패킷을 만들때 준 배열)인 data에 담아져 있음
				//이것을 String생성자을 이용하여 문자열로 만듬
				String msg = new String(data);
				System.out.println("수신된데이터: "+msg);
				
				//다음 수신되는 데이터를 위해 byte의 배열 data를 비워야함
				Arrays.fill(data, (byte)0);
			}
			
		}catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}
}
