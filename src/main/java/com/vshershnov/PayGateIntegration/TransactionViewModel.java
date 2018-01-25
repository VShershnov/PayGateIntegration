package com.vshershnov.PayGateIntegration;

import java.io.IOException;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import com.vshershnov.PayGateIntegration.domain.Transaction;
import com.vshershnov.PayGateIntegration.services.TransactionService;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class TransactionViewModel {

	@WireVariable
	private TransactionService transactionService;
	private Transaction transaction;
		
	@Init
	public void init() {
		transaction = new Transaction();
	}

	@Command	
	public void sale() throws IOException {
		transactionService.sale(transaction);
		Executions.sendRedirect("/result.zul");		
	}
	
	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}	
	
	public TransactionService getTransactionService() {
		return transactionService;
	}	
	
	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
