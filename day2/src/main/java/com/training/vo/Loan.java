package com.training.vo;

public class Loan {
	private int id;
	private String bankName;
	private int quarter;
	private int year;
	private double amount;
	private String notes;

	public Loan() {
		super();
	}

	public Loan(String bankName, double amount) {
		super();
		this.bankName = bankName;
		this.amount = amount;
	}

	public Loan(String bankName, int quarter, int year, double amount) {
		super();
		this.bankName = bankName;
		this.quarter = quarter;
		this.year = year;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", bankName=" + bankName + ", quarter="
				+ quarter + ", year=" + year + ", amount=" + amount
				+ ", notes=" + notes + "]";
	}
}
