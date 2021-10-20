package com.sist.exam03;

import java.util.Scanner;

public class StringTestStartWith {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ÀÌ¸§À» ÀÔ·ÂÇÏ¼¼¿ä==>");
		String name = sc.next();
		
		if(name.startsWith("±è")) {
			System.out.println("±è¾¾ÀÔ´Ï´Ù.");
		}else
			System.out.println("±è¾¾°¡ ¾Æ´Õ´Ï´Ù.");
	}
}
