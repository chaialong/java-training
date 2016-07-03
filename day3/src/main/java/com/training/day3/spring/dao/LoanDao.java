package com.training.day3.spring.dao;

import java.util.List;

public interface LoanDao {
	public List selectAll();
	public void insertTwo(Loan l)  throws Exception;
}
