package com.sist.exam07;

public class BankAccountTest {

	public static void main(String[] args) {
		try {
		BankAccount user = new BankAccount();
		BankAccount user2 = new BankAccount();
		
		user.deposit(100000);
		user.withdraw(40000);
		System.out.println("�ܾ�: " + user.getBalance());
		
		user2.deposit(100000);
		user2.withdraw(200000);
		System.out.println("�ܾ�: " + user2.getBalance());
		
		}catch(NegativeBalanceException n) {
			System.out.println("���� �߻�: "+n.getMessage());
		}

	}

} 
