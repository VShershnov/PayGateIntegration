package com.vshershnov.PayGateIntegration.services;

import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

	String ask(String question);
	//String sale(String question);
}
