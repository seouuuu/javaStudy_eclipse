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
			throw new NegativeBalanceException("인출금액이 잔액을 초과합니다.");
		}
		balance -=n;
	}
	
}
