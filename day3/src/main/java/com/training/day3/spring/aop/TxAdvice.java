package com.training.day3.spring.aop;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TxAdvice {
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Around("execution(* com..*.insert*(..))") 
	public void tx(ProceedingJoinPoint point) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			point.proceed();
			conn.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
