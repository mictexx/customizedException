package model.entities;


import model.exceptions.DomainExceptions;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Account() {
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	

	
	public void deposit(Double amount) {
		this.balance += amount;
		
	}
	
	public void withdraw(Double amount) {
		
		if (getBalance() == 0 ) {
			//throw new IllegalArgumentException("Error in reservation: Check-out date must be after check-in date!");
			throw new DomainExceptions("Withdraw error: No balance");
		}else if (getBalance() < amount  ) {
			//throw new IllegalArgumentException("Error in reservation: Check-out date must be after check-in date!");
			throw new DomainExceptions("Withdraw error: Not enough balance");
		}else if ( amount > getWithdrawLimit() ) {
			//throw new IllegalArgumentException("Error in reservation: Check-out date must be after check-in date!");
			throw new DomainExceptions("Withdraw error: The amount exceeds withdraw limit");
		}else
		balance -= amount;
		
	}
		
		@Override
		public String toString() {
			return "New balance: "
					+ String.format("%.2f", getBalance());
		}
	
	
}
