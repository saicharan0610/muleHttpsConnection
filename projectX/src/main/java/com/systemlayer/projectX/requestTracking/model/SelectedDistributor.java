package com.systemlayer.projectX.requestTracking.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SelectedDistributor {
	@JsonProperty("DistributorId")
	private String distributorId;
	@JsonProperty("DistributorName")
	private String distributorName;
	@JsonProperty("PhoneNumber")
	private String phoneNumber;
	@JsonProperty("Companies")
	private List<Companies> companies;
	
	
	public String getDistributorId() {
		return distributorId;
	}
	public void setDistributorId(String distributorId) {
		this.distributorId = distributorId;
	}
	public String getDistributorName() {
		return distributorName;
	}
	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<Companies> getCompanies() {
		return companies;
	}
	public void setCompanies(List<Companies> companies) {
		this.companies = companies;
	}
	
	

}
