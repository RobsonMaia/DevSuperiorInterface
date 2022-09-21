package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installment {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dueDeate;
	private Double amount;
	
	public Installment() {
	}

	public Installment(Date dueDeate, Double amount) {
		super();
		this.dueDeate = dueDeate;
		this.amount = amount;
	}

	public Date getDueDeate() {
		return dueDeate;
	}

	public void setDueDeate(Date dueDeate) {
		this.dueDeate = dueDeate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return sdf.format(dueDeate) + " - " + String.format("%2.f", amount); 
	}
	
	
}
