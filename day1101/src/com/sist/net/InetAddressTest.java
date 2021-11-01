package com.sist.net;

import java.net.InetAddress;

public class InetAddressTest {

	public static void main(String[] args) {
		
		try {
			//InetAddress naver = InetAddress.getByName("www.naver.com");
			//System.out.println(naver);
			
			InetAddress []list = InetAddress.getAllByName("www.naver.com");
			for(InetAddress naver : list) {
				System.out.println(naver);
			}
		}catch (Exception e) {
			System.out.println("���ܹ߻�: "+e.getMessage());
		}
	}
}
