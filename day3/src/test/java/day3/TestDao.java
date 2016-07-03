package day3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.training.day3.spring.dao.Loan;
import com.training.day3.spring.dao.LoanDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestDao {
	@Autowired
	@Qualifier("loanDao2")
	LoanDao loanDao;

	@Test
	public void test() throws Exception {
		/*List<Loan> loans = loanDao.selectAll();
		for (Loan loan : loans) {
			System.out.println(loan);
		}*/
		
		loanDao.insertTwo(new Loan(1, "icbc", 2000));
	}

}
