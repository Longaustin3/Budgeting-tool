// Transaction will include the date: DD/MM/YYYY gain or loss: +/- total: $00.00 and Type

package application;

import java.time.LocalDate;
import java.util.Arrays;

public class Transaction {
	
	private double ammount;
	private LocalDate date;
	private String type;
	private char posOrNeg;
	private String[] types = {"Housing", "Utilities", "Food", "Transportation", "Healthcare", "Debt"};
	
	public Transaction () {
		this.posOrNeg = '+';
		this.ammount = 0.00;
		this.type = null;
		this.date = LocalDate.now();
	}
	
	public Transaction (char posOrNeg, double ammount, LocalDate date, String type) {
		this.posOrNeg = posOrNeg;
		this.ammount = ammount;
		this.date = date;
		if (Arrays.asList(types).contains(type)) {
			this.type = type;
		}
		else {
			System.out.println("Not a valid type");
		}
		this.type = type;
	}
	
	public double getTotal() {
		return ammount;
	}
	
	public String getType() {
		return type;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public String getPosOrNeg() {
		if (posOrNeg == '+')
			return "Deposit";
		else
			return "Withdrawal";
	}
	
	public void setTotal(double ammount) {
		this.ammount = ammount;
	}
	
	@Override
	public String toString() {
		return date + " " + type + " " + posOrNeg + ammount;
	}
}
