package com.vshershnov.PayGateIntegration.services.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vshershnov.PayGateIntegration.domain.Transaction;
import com.vshershnov.PayGateIntegration.services.TransactionService;

@Service("transactionService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TransactionServiceImpl implements TransactionService {	
	
	private boolean transactionResult;
	
	public void sale(Transaction transaction) {
		System.out.println(transaction.toString());		
		setTransactionResult(true);
	}

	public void setTransactionResult(boolean transactionResult) {
		this.transactionResult = transactionResult;
	}

	public boolean isSaleSuccessful() {		
		return transactionResult;
	}
}