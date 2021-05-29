package com.systemlayer.projectX.requestTracking.model;

import java.math.BigDecimal;
import java.net.Inet4Address;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SkuDetails {
	@JsonProperty("CompanyId")
	private String companyId;
	@JsonProperty("CompanyName")
	private String companyName;
	@JsonProperty("SkuId")
	private String skuId;
	@JsonProperty("SkuName")
	private String skuName;
	@JsonProperty("UnitMRP")
	private  Integer unitMrp;
	@JsonProperty("UnitsPerSU")
	private Integer unitPerSU;
	@JsonProperty("Balance")
	private Integer balance;
	@JsonProperty("SUCost")
	private BigDecimal sunitCase;
	@JsonProperty("SUPercase")
	private Integer supCase;
	@JsonProperty("QuantityInSU")
	private Integer quantitySU;
	
	
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
	public Integer getQuantitySU() {
		return quantitySU;
	}
	public void setQuantitySU(Integer quantitySU) {
		this.quantitySU = quantitySU;
	}
	
	
}
