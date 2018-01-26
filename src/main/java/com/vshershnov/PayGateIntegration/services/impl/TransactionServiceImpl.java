package com.vshershnov.PayGateIntegration.services.impl;

import java.io.IOException;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import com.vshershnov.PayGateIntegration.domain.Transaction;
import com.vshershnov.PayGateIntegration.services.TransactionService;
import com.vshershnov.PayGateIntegration.services.UnichargeProcessingAPIService;

@Service("transactionService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TransactionServiceImpl implements TransactionService {	
	
	@WireVariable
	private UnichargeProcessingAPIService unichargeProcessingAPIService = new UnichargeProcessingAPIServiceImp();
	private boolean transactionResult;
	
	public void sale(Transaction transaction) throws IOException {		
		
		System.out.println(transaction.toString());
		String result = unichargeProcessingAPIService.sendSaleTransaction(transaction);
		System.out.println(result);
		
		if(isSaleSuccessful(result)){
			setTransactionResult(true);
		}		
	}

	private boolean isSaleSuccessful(String result) {
		
		if(result.equals("Approved")){
			return false;
		}
		return false;
	}

	public void setTransactionResult(boolean transactionResult) {
		this.transactionResult = transactionResult;
	}

	public boolean isSaleSuccessful() {		
		return transactionResult;
	}
}