package com.systemlayer.projectX.requestTracking.Responses;

import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class BillNumberWiseResponse {
	
	 private Date transactionDate;
	 private String distributor;
	 private Double amount;
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

	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(Integer billNumber) {
		this.billNumber = billNumber;
	}
	 

	 

	 

}
