package com.training.day3.spring.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.training.day3.spring.dao.Loan;
import com.training.day3.spring.dao.LoanDao;

public class DefaultLoanDao implements LoanDao {
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List selectAll() {
		List r = new ArrayList();
		try (Connection conn = dataSource.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from loan");) {

			while (rs.next()) {
				r.add(new Loan(rs.getInt(1), rs.getString(2), rs.getInt(3)));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return r;
	}

	@Override
	public void insertTwo(Loan l) {
		// TODO Auto-generated method stub
		
	}

}
