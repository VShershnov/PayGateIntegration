package com.vshershnov.PayGateIntegration.services;

import com.vshershnov.PayGateIntegration.domain.Transaction;

public interface TransactionService {
	
	boolean isSaleSuccessful();
	void sale(Transaction transaction);
}
