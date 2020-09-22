package com.citi.mongodb.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subJourney")
public class TTDataDictionarySubJourney {

	@Id
	private String subJourneyId;
	private String bankApplication;
	private String cardApplication;
	private String activation;
	private String findAndLearn;
	private String cli;
	private String cashAdavance;
	private String lineOfCredit;
	private String monitorMyLoan;
	private String openLoanAccount;
	private String pil;
	private String apr;
	private String creditWarning;
	private String fee;
	private String pricing;
	private String balanceTransfers;
	private String chatrBots;
	private String olsMessage;
	private String secureMessage;
	private String atmBranchLocations;
	private String contactUs;
	private String faq;
	private String feedback;
	private String help;
	private String search;
	public String getSubJourneyId() {
		return subJourneyId;
	}
	public void setSubJourneyId(String subJourneyId) {
		this.subJourneyId = subJourneyId;
	}
	public String getBankApplication() {
		return bankApplication;
	}
	public void setBankApplication(String bankApplication) {
		this.bankApplication = bankApplication;
	}
	public String getCardApplication() {
		return cardApplication;
	}
	public void setCardApplication(String cardApplication) {
		this.cardApplication = cardApplication;
	}
	public String getActivation() {
		return activation;
	}
	public void setActivation(String activation) {
		this.activation = activation;
	}
	public String getFindAndLearn() {
		return findAndLearn;
	}
	public void setFindAndLearn(String findAndLearn) {
		this.findAndLearn = findAndLearn;
	}
	public String getCli() {
		return cli;
	}
	public void setCli(String cli) {
		this.cli = cli;
	}
	public String getCashAdavance() {
		return cashAdavance;
	}
	public void setCashAdavance(String cashAdavance) {
		this.cashAdavance = cashAdavance;
	}
	public String getLineOfCredit() {
		return lineOfCredit;
	}
	public void setLineOfCredit(String lineOfCredit) {
		this.lineOfCredit = lineOfCredit;
	}
	public String getMonitorMyLoan() {
		return monitorMyLoan;
	}
	public void setMonitorMyLoan(String monitorMyLoan) {
		this.monitorMyLoan = monitorMyLoan;
	}
	public String getOpenLoanAccount() {
		return openLoanAccount;
	}
	public void setOpenLoanAccount(String openLoanAccount) {
		this.openLoanAccount = openLoanAccount;
	}
	public String getPil() {
		return pil;
	}
	public void setPil(String pil) {
		this.pil = pil;
	}
	public String getApr() {
		return apr;
	}
	public void setApr(String apr) {
		this.apr = apr;
	}
	public String getCreditWarning() {
		return creditWarning;
	}
	public void setCreditWarning(String creditWarning) {
		this.creditWarning = creditWarning;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getPricing() {
		return pricing;
	}
	public void setPricing(String pricing) {
		this.pricing = pricing;
	}
	public String getBalanceTransfers() {
		return balanceTransfers;
	}
	public void setBalanceTransfers(String balanceTransfers) {
		this.balanceTransfers = balanceTransfers;
	}
	public String getChatrBots() {
		return chatrBots;
	}
	public void setChatrBots(String chatrBots) {
		this.chatrBots = chatrBots;
	}
	public String getOlsMessage() {
		return olsMessage;
	}
	public void setOlsMessage(String olsMessage) {
		this.olsMessage = olsMessage;
	}
	public String getSecureMessage() {
		return secureMessage;
	}
	public void setSecureMessage(String secureMessage) {
		this.secureMessage = secureMessage;
	}
	public String getAtmBranchLocations() {
		return atmBranchLocations;
	}
	public void setAtmBranchLocations(String atmBranchLocations) {
		this.atmBranchLocations = atmBranchLocations;
	}
	public String getContactUs() {
		return contactUs;
	}
	public void setContactUs(String contactUs) {
		this.contactUs = contactUs;
	}
	public String getFaq() {
		return faq;
	}
	public void setFaq(String faq) {
		this.faq = faq;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getHelp() {
		return help;
	}
	public void setHelp(String help) {
		this.help = help;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
}
