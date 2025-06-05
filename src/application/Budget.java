package application;

import java.util.ArrayList;

public class Budget {
	ArrayList<Transaction> expenses = new ArrayList<>();
		
	public void addTransaction(Transaction transaction) {
		expenses.add(transaction);
	}
	
	public void removeTransaction(Transaction transaction) {
		expenses.remove(transaction);
	}
	
	public ArrayList<Transaction> getTransactions() {
		return expenses;
	}
}

// Needs to be able to add a transaction
// Needs to be able to delete a transaction
