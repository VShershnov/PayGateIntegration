package com.vshershnov.PayGateIntegration.services;

import java.io.IOException;

import com.vshershnov.PayGateIntegration.domain.Transaction;

public interface UnichargeProcessingAPIService {

	public String sendSaleTransaction(Transaction transaction) throws IOException;
}