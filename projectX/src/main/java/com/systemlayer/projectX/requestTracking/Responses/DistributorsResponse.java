package com.systemlayer.projectX.requestTracking.Responses;

import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class DistributorsResponse {
	private String distributorId;
	private String distributorName;
	private List<CompaniesResponse> companies;
	private String companiesList;
	
	public String getCompaniesList() {
		return companiesList;
	}
	public void setCompaniesList(String companiesList) {
		this.companiesList = companiesList;
	}
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
	public List<CompaniesResponse> getCompanies() {
		return companies;
	}
	public void setCompanies(List<CompaniesResponse> companies) {
		this.companies = companies;
	}
	
	

}
