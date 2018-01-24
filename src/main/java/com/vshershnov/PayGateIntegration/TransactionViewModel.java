package com.vshershnov.PayGateIntegration;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import com.vshershnov.PayGateIntegration.services.TransactionService;

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
	

	@Command
	public void sale() throws IOException {
		if (!transactionService.sale("any").isEmpty()) {
		    Executions.sendRedirect("/result.zul");
		}
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
