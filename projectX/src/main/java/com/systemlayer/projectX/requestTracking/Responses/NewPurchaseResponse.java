package com.systemlayer.projectX.requestTracking.Responses;


import java.math.BigDecimal;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewPurchaseResponse {

	@JsonProperty("TransactionDate")
	private Date transactionDate;
	@JsonProperty("Distributor")
	private String distributor;
	@JsonProperty("Amount")
	private BigDecimal amount;
	@JsonProperty("BillNumber")
	private Integer billNumber;
	
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getDistributor() {
		return distributor;
	}
	public void setDistributor(String distributor) {
		this.distributor = distributor;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Integer getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(Integer billNumber) {
		this.billNumber = billNumber;
	}
	
	
}
