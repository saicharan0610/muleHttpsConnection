package com.systemlayer.projectX.requestTracking.Responses;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;




public class SkuDetailsResponse {
	
	@JsonProperty("companyId")
	private String companyId;
	@JsonProperty("companyName")
	private String companyName;
	@JsonProperty("skuId")
	private String skuId;
	@JsonProperty("skuName")
	private String skuName;
	@JsonProperty("unitMrp")
	private Integer unitMrp;
	@JsonProperty("unitPerSU")
	private Integer unitPerSU;
	@JsonProperty("balance")
	private Integer balance;
	@JsonProperty("SUnitC")
	private BigDecimal sunitCase;
	@JsonProperty("SUPercase")
	private Integer supCase;
	
	
	
	public BigDecimal getSunitCase() {
		return sunitCase;
	}
	public void setSunitCase(BigDecimal sunitCase) {
		this.sunitCase = sunitCase;
	}
	public Integer getSupCase() {
		return supCase;
	}
	public void setSupCase(Integer supCase) {
		this.supCase = supCase;
	}
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
	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	public Integer getUnitMrp() {
		return unitMrp;
	}
	public void setUnitMrp(Integer unitMrp) {
		this.unitMrp = unitMrp;
	}
	public Integer getUnitPerSU() {
		return unitPerSU;
	}
	public void setUnitPerSU(Integer unitPerSU) {
		this.unitPerSU = unitPerSU;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	
	

}
