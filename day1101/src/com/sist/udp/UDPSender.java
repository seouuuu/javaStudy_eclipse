//java UDPSender 172.30.1.4 안녕
//java UDPSender 172.30.1.4 반갑습니다

package com.sist.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSender {
	public static void main(String[] args) {
		
		String ip = args[0];
		String msg = args[1];
		
		
		//UDP 방식에서 데이터를 주고 받기 위해서는 DatagramSocket이 필요
		//DatagramSocket(int port)
		try {
			DatagramSocket socket = new DatagramSocket();
			
			//목적지의 주소 ip를 가지고 InetAddress객체 생성
			InetAddress addr = InetAddress.getByName(ip);
			
			//전송하고자하는 문자열 msg를 byte의 배열로 만듬
			byte[]data = msg.getBytes();
			
			//UDP방식의 데이터전송단위 패킷 생성
			DatagramPacket packet = new DatagramPacket(data, data.length, addr, 9002);
			
			//DatagramSocket의 send메소드를 통해 데이터를 전송
			socket.send(packet);
			
			//소켓 닫기
			socket.close();
			
			
		}catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}
}
