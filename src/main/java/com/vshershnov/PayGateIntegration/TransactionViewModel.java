package com.vshershnov.PayGateIntegration;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.vshershnov.PayGateIntegration.services.TransactionService;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class TransactionViewModel {
	
	@WireVariable
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
		cardNumber = "9999 9999 9999 9999 9999";
	}

	@Command
	@NotifyChange("answer")
	public void cmd() {
		answer = transactionService.ask("What day is today?");
	}

	public String getAnswer() {
		return answer;
	}	
	
	/**
	 * @return the holderName
	 */
	public String getHolderName() {
		return holderName;
	}

	/**
	 * @param holderName the holderName to set
	 */
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	/**
	 * @param transactionService the transactionService to set
	 */
	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @param cardNumber the cardNumber to set
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @param expDate the expDate to set
	 */
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	/**
	 * @param cscCode the cscCode to set
	 */
	public void setCscCode(String cscCode) {
		this.cscCode = cscCode;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the transactionService
	 */
	public TransactionService getTransactionService() {
		return transactionService;
	}

	/**
	 * @return the cardNumber
	 */
	@NotNull(message="{field.empty}")
	@Size(min=16, message="{creditCard.number.size}")
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @return the expDate
	 */
	public String getExpDate() {
		return expDate;
	}

	/**
	 * @return the cscCode
	 */
	public String getCscCode() {
		return cscCode;
	}

	/**
	 * @return the amount
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * @return the holdername
	 */
	public String getHoldername() {
		return holderName;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	
}
