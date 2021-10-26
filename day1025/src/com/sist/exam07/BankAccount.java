package com.sist.exam07;

public class BankAccount  {
	int balance=0;
	
	
	public int getBalance() {
		return balance;
	}

	public void deposit(int n) {
		balance += n;
	}
	
	public void withdraw(int n) throws NegativeBalanceException{
		
		if(n>balance) {
			throw new NegativeBalanceException("����ݾ��� �ܾ��� �ʰ��մϴ�.");
		}
		balance -=n;
	}
	
}
