package com.vshershnov.PayGateIntegration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.zkoss.zkspringmvc.ZKModelAndView;
import org.zkoss.zkspringmvc.annotation.ZKCommandLifecycle;
import org.zkoss.zkspringmvc.annotation.ZKNotifyChange;
import org.zkoss.zkspringmvc.annotation.ZKVariable;

import com.vshershnov.PayGateIntegration.services.TransactionService;

@Controller
@RequestMapping("/transaction")
@SessionAttributes({"transactionVM"})
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;

	
	@RequestMapping(value = "/ask", method = RequestMethod.POST)
	@ZKCommandLifecycle
	@ZKNotifyChange({"vm.answer"})
	public String cmd(@ZKVariable String answer) {
		answer = transactionService.ask("What day is today?");
		return ZKModelAndView.SELF;
	}
}
