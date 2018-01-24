package com.vshershnov.PayGateIntegration;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import com.vshershnov.PayGateIntegration.services.TransactionService;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ResultViewModel {

	@WireVariable
	private TransactionService transactionService;
	private String answer;
	
	@Init
	public void init() {
		answer = transactionService.isSaleSuccessful() ? "sale successful" : "sale unsuccessful";
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}	
}
