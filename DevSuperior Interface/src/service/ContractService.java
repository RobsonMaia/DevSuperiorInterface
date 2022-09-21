package service;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinepaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinepaymentService = onlinePaymentService;
		
	}
	
	public void processContrsct(Contract contract, int months) {
		double basicQuota = contract.getTotalValue() / months;
		// basicQuota valendo 200 neste momento
		for (int i = 1; i <= months; i++) {
			double updatedQuota = basicQuota + onlinepaymentService.interest(basicQuota, i);
			// basicQuota valendo 202 neste momento
			double fullQuota = updatedQuota + onlinepaymentService.patmentFee(updatedQuota);
			// fullQuota valendo 206.04 neste momento
			Date dueDate = addMonths(contract.getDate(), i);
			contract.getInstallment().add(new Installment(dueDate, fullQuota));
			
			
		}
	}
	
	private Date addMonths(Date date, int N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, N);
		return calendar.getTime();	
	}
}
