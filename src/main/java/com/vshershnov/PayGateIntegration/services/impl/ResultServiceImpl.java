package com.vshershnov.PayGateIntegration.services.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import com.vshershnov.PayGateIntegration.services.ResultService;

@Service("resultService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ResultServiceImpl implements ResultService {	

	
	public String isSaleSuccessful(String result) {
		// TODO Auto-generated method stub
		return "true";
	}

}
