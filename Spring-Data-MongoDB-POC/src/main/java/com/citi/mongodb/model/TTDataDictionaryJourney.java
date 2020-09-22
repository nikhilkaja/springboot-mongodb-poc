package com.citi.mongodb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "journey")
public class TTDataDictionaryJourney {

	@Id
	private String journeyId;
	private String applyForAccount;
	private String onboardForAccount;
	private String shopForAccount;
	private String addAdditionalCreditAndLoans;
	private String borrowNewFunds;
	private String PricingOrAPROrFee;
	private String RestructureExistingCredit;
	private String transferLoans;
	private String messaging;
	private String mobileContainer;
	private String nonDigital;
	private String digitalContainer;
	private String voice;
	private String addAProduceOrService;
	private String crossSellAndUpgrades;
	private String manageMyBenifits;
	private String manageMyRewards;
	private String onboardMyAccount;
	private String loginAutnetication;
	private String manageProfile;
	private String protectIdentity;
	private String RegisterForDigitalAccess;
	private String secureMyInformation;
	private String billPay;
	private String makeADigitalPurchase;
	public String getJourneyId() {
		return journeyId;
	}
	public void setJourneyId(String journeyId) {
		this.journeyId = journeyId;
	}
	public String getApplyForAccount() {
		return applyForAccount;
	}
	public void setApplyForAccount(String applyForAccount) {
		this.applyForAccount = applyForAccount;
	}
	public String getOnboardForAccount() {
		return onboardForAccount;
	}
	public void setOnboardForAccount(String onboardForAccount) {
		this.onboardForAccount = onboardForAccount;
	}
	public String getShopForAccount() {
		return shopForAccount;
	}
	public void setShopForAccount(String shopForAccount) {
		this.shopForAccount = shopForAccount;
	}
	public String getAddAdditionalCreditAndLoans() {
		return addAdditionalCreditAndLoans;
	}
	public void setAddAdditionalCreditAndLoans(String addAdditionalCreditAndLoans) {
		this.addAdditionalCreditAndLoans = addAdditionalCreditAndLoans;
	}
	public String getBorrowNewFunds() {
		return borrowNewFunds;
	}
	public void setBorrowNewFunds(String borrowNewFunds) {
		this.borrowNewFunds = borrowNewFunds;
	}
	public String getPricingOrAPROrFee() {
		return PricingOrAPROrFee;
	}
	public void setPricingOrAPROrFee(String pricingOrAPROrFee) {
		PricingOrAPROrFee = pricingOrAPROrFee;
	}
	public String getRestructureExistingCredit() {
		return RestructureExistingCredit;
	}
	public void setRestructureExistingCredit(String restructureExistingCredit) {
		RestructureExistingCredit = restructureExistingCredit;
	}
	public String getTransferLoans() {
		return transferLoans;
	}
	public void setTransferLoans(String transferLoans) {
		this.transferLoans = transferLoans;
	}
	public String getMessaging() {
		return messaging;
	}
	public void setMessaging(String messaging) {
		this.messaging = messaging;
	}
	public String getMobileContainer() {
		return mobileContainer;
	}
	public void setMobileContainer(String mobileContainer) {
		this.mobileContainer = mobileContainer;
	}
	public String getNonDigital() {
		return nonDigital;
	}
	public void setNonDigital(String nonDigital) {
		this.nonDigital = nonDigital;
	}
	public String getDigitalContainer() {
		return digitalContainer;
	}
	public void setDigitalContainer(String digitalContainer) {
		this.digitalContainer = digitalContainer;
	}
	public String getVoice() {
		return voice;
	}
	public void setVoice(String voice) {
		this.voice = voice;
	}
	public String getAddAProduceOrService() {
		return addAProduceOrService;
	}
	public void setAddAProduceOrService(String addAProduceOrService) {
		this.addAProduceOrService = addAProduceOrService;
	}
	public String getCrossSellAndUpgrades() {
		return crossSellAndUpgrades;
	}
	public void setCrossSellAndUpgrades(String crossSellAndUpgrades) {
		this.crossSellAndUpgrades = crossSellAndUpgrades;
	}
	public String getManageMyBenifits() {
		return manageMyBenifits;
	}
	public void setManageMyBenifits(String manageMyBenifits) {
		this.manageMyBenifits = manageMyBenifits;
	}
	public String getManageMyRewards() {
		return manageMyRewards;
	}
	public void setManageMyRewards(String manageMyRewards) {
		this.manageMyRewards = manageMyRewards;
	}
	public String getOnboardMyAccount() {
		return onboardMyAccount;
	}
	public void setOnboardMyAccount(String onboardMyAccount) {
		this.onboardMyAccount = onboardMyAccount;
	}
	public String getLoginAutnetication() {
		return loginAutnetication;
	}
	public void setLoginAutnetication(String loginAutnetication) {
		this.loginAutnetication = loginAutnetication;
	}
	public String getManageProfile() {
		return manageProfile;
	}
	public void setManageProfile(String manageProfile) {
		this.manageProfile = manageProfile;
	}
	public String getProtectIdentity() {
		return protectIdentity;
	}
	public void setProtectIdentity(String protectIdentity) {
		this.protectIdentity = protectIdentity;
	}
	public String getRegisterForDigitalAccess() {
		return RegisterForDigitalAccess;
	}
	public void setRegisterForDigitalAccess(String registerForDigitalAccess) {
		RegisterForDigitalAccess = registerForDigitalAccess;
	}
	public String getSecureMyInformation() {
		return secureMyInformation;
	}
	public void setSecureMyInformation(String secureMyInformation) {
		this.secureMyInformation = secureMyInformation;
	}
	public String getBillPay() {
		return billPay;
	}
	public void setBillPay(String billPay) {
		this.billPay = billPay;
	}
	public String getMakeADigitalPurchase() {
		return makeADigitalPurchase;
	}
	public void setMakeADigitalPurchase(String makeADigitalPurchase) {
		this.makeADigitalPurchase = makeADigitalPurchase;
	}
	
}
