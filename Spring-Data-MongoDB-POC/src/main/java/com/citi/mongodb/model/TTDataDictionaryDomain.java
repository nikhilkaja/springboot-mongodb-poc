package com.citi.mongodb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "domain")
public class TTDataDictionaryDomain {

	@Id
	private int domainId;
	private String acquire;
	private String borrow;
	private String enable;
	private String grow;
	private String identify;
	private String pay;
	private String saveAndInvest;
	private String servicing;
	
	public int getDomainId() {
		return domainId;
	}
	public void setDomainId(int domainId) {
		this.domainId = domainId;
	}
	public String getAcquire() {
		return acquire;
	}
	public void setAcquire(String acquire) {
		this.acquire = acquire;
	}
	public String getBorrow() {
		return borrow;
	}
	public void setBorrow(String borrow) {
		this.borrow = borrow;
	}
	public String getEnable() {
		return enable;
	}
	public void setEnable(String enable) {
		this.enable = enable;
	}
	public String getGrow() {
		return grow;
	}
	public void setGrow(String grow) {
		this.grow = grow;
	}
	public String getIdentify() {
		return identify;
	}
	public void setIdentify(String identify) {
		this.identify = identify;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getSaveAndInvest() {
		return saveAndInvest;
	}
	public void setSaveAndInvest(String saveAndInvest) {
		this.saveAndInvest = saveAndInvest;
	}
	public String getServicing() {
		return servicing;
	}
	public void setServicing(String servicing) {
		this.servicing = servicing;
	}
	
}
