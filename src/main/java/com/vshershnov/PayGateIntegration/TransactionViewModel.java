package com.vshershnov.PayGateIntegration;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.zkoss.bind.annotation.Init;

import com.vshershnov.PayGateIntegration.services.TransactionService;

public class TransactionViewModel {
	
	private TransactionService transactionService;
	
	private String answer;
	private String cardNumber;
	private String expDate;
	private String cscCode;
	
	private Long amount;
	
	private String holderName;	
	private String street;
	private String city;
	private String state;
	private String zipCode;
	
	@Init
	public void init() {
		answer = "?";		
	}

	public String getAnswer() {
		return answer;
	}
	
	public String getHolderName() {
		return holderName;
	}
	
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	
	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	
	public void setCscCode(String cscCode) {
		this.cscCode = cscCode;
	}
	
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public TransactionService getTransactionService() {
		return transactionService;
	}

	
	@NotNull(message="{field.empty}")
	@Size(min=16, message="{creditCard.number.size, should be 16}")
	public String getCardNumber() {
		return cardNumber;
	}
	
	public String getExpDate() {
		return expDate;
	}

	public String getCscCode() {
		return cscCode;
	}
	
	public Long getAmount() {
		return amount;
	}
	
	public String getHoldername() {
		return holderName;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZipCode() {
		return zipCode;
	}	
}
