package service;

public interface OnlinePaymentService {

	double patmentFee(double amount);
	double interest(double amount, int monthis);


}
