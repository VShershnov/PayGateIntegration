package com.vshershnov.PayGateIntegration.services;

import java.io.IOException;

import com.vshershnov.PayGateIntegration.domain.Transaction;

public interface TransactionService {
	
	boolean isSaleSuccessful();
	void sale(Transaction transaction) throws IOException;
}
