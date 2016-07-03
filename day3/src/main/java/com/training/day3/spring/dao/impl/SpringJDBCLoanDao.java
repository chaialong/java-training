package com.training.day3.spring.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.day3.spring.dao.Loan;
import com.training.day3.spring.dao.LoanDao;

public class SpringJDBCLoanDao extends JdbcDaoSupport implements LoanDao {

	public List selectAll() {
		// TODO Auto-generated method stub
		return getJdbcTemplate().query("select * from loan", new RowMapper<Loan>() {

			public Loan mapRow(ResultSet rs, int arg1) throws SQLException {
				return new Loan(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}
			
		});
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor={SQLException.class})
	public void insertTwo(Loan l) throws Exception {
		getJdbcTemplate().update("insert into loan(bank_name, year) values(?,?)",
				l.getName(), l.getYear());
		getJdbcTemplate().update("insert into loan(bank_name, year) values(?,?)",
				l.getName(), l.getYear());
		
		throw new SQLException("test exeption!");
	}

}


