package com.systemlayer.projectX.requestTracking.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Companies {
	@JsonProperty("CompanyId")
	private String companyId;
	@JsonProperty("CompanyName")
	private String companyName;
	@JsonProperty("SKUs")
	private List<SkuDetails> sKuDetails;
	@JsonProperty("NewSKUs")
	private List<SkuDetails> newSkuDetails;
	
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public List<SkuDetails> getsKuDetails() {
		return sKuDetails;
	}
	public void setsKuDetails(List<SkuDetails> sKuDetails) {
		this.sKuDetails = sKuDetails;
	}
	public List<SkuDetails> getNewSkuDetails() {
		return newSkuDetails;
	}
	public void setNewSkuDetails(List<SkuDetails> newSkuDetails) {
		this.newSkuDetails = newSkuDetails;
	}
	
	
	
	

}
