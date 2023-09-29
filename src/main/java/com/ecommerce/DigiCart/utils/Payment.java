package com.ecommerce.DigiCart.utils;

public class Payment {
	private String currency;
	private long amount;
	private String reciept;
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getReciept() {
		return reciept;
	}
	public void setReciept(String reciept) {
		this.reciept = reciept;
	}
	
}
