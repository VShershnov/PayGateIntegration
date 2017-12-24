package com.vshershnov.PayGateIntegration;

import java.util.Date;

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
	 * @return the transactionService
	 */
	public TransactionService getTransactionService() {
		return transactionService;
	}

	/**
	 * @return the cardNumber
	 */
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
