package com.sist.exam01;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BankAccount account = new BankAccount();
			account.deposit(1000);
			account.withdraw(500);
			account.withdraw(1000);
			
		}catch(NegativeBalanceException e) {
			//System.out.println("���ܹ߻�:"+e.getMessage());
			e.printStackTrace();
		}
	}

}
