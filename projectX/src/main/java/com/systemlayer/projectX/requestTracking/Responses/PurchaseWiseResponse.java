package com.systemlayer.projectX.requestTracking.Responses;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class PurchaseWiseResponse {
	
	private Date transactionDate;
	private BigDecimal amount;
	private String Distributor;
	

	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getDistributor() {
		return Distributor;
	}
	public void setDistributor(String distributor) {
		Distributor = distributor;
	}
	
	

}
