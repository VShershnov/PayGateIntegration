package com.vshershnov.PayGateIntegration.services.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vshershnov.PayGateIntegration.services.TransactionService;

@Service("transactionService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TransactionServiceImpl implements TransactionService {	
	
	public String sale(String question1) {
		// TODO Auto-generated method stub
		return "Sale done";
	}
}