package com.training.ssh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.training.ssh.dao.LoanDao;
import com.training.ssh.vo.Loan;

@Controller
public class LoanController {
	@Autowired
	private LoanDao loanDao;
	
	public LoanDao getLoanDao() {
		return loanDao;
	}

	public void setLoanDao(LoanDao loanDao) {
		this.loanDao = loanDao;
	}

	@RequestMapping("/listLoan.do") 
	public List<Loan> list(int page) {
		if(page==0) page = 1;
		return loanDao.selectAll(page);
	}
}



