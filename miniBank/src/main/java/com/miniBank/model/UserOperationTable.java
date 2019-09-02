package com.miniBank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "USEROPERATIONS")
public class UserOperationTable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Integer userId;
	private long deposit;
	private long withdrawal;
	private long balance;
	
    public UserOperationTable() {
    }
    
	public UserOperationTable (int userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public long getDeposit() {
		return deposit;
	}

	public void setDeposit(long deposit) {
		this.deposit = deposit;
	}

	public long getWithdrawal() {
		return withdrawal;
	}

	public void setWithdrawal(long withdrawal) {
		this.withdrawal = withdrawal;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}
	
}
