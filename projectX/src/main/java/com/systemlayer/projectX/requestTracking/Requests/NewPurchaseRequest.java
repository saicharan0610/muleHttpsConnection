package com.systemlayer.projectX.requestTracking.Requests;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.systemlayer.projectX.requestTracking.model.SelectedDistributor;

public class NewPurchaseRequest {
	
	@JsonProperty("TransactionDate")
	private Date transactionDate;
	@JsonProperty("BillNumber")
	private Integer billNumber;
	@JsonProperty("SelectedDistributor")
	private SelectedDistributor selectedDistributor;
	
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Integer getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(Integer billNumber) {
		this.billNumber = billNumber;
	}
	public SelectedDistributor getSelectedDistributor() {
		return selectedDistributor;
	}
	public void setSelectedDistributor(SelectedDistributor selectedDistributor) {
		this.selectedDistributor = selectedDistributor;
	}
	
	
	

}
