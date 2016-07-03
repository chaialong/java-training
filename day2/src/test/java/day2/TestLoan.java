package day2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.training.vo.Loan;

public class TestLoan {

	@Test
	public void test() {
		/*StandardServiceRegistry registry = 
				new StandardServiceRegistryBuilder().configure("hibernate.xml")
													.build();
		Metadata meta = new MetadataSources(registry).buildMetadata();
		
		SessionFactory factory = meta.buildSessionFactory();*/
		
		SessionFactory factory = new Configuration().configure("hibernate.xml")
													.buildSessionFactory();
											
		
		Session session = factory.openSession();
		
		/*Loan l = session.load(Loan.class, 1);
		System.out.println(l.getClass());
		
		if(!Hibernate.isInitialized(l)) {
			Hibernate.initialize(l);
		}*/
		
		/*Loan l = new Loan("icbc", 3, 2009, 2000);
		l.setId(2);
		session.beginTransaction();
		session.saveOrUpdate(l);
		System.out.println(l.getId());
		session.getTransaction().commit();*/
		
		/*Query query = session.createQuery("from Loan where bankName=:name");
		query.setString("name", "icbc");*/
		/*List<Loan> loans = query.list();
		for(Loan loan:loans) {
			System.out.println(loan);
		}*/
		
		/*Iterator<Loan> it = query.iterate();
		while(it.hasNext()) {
			System.out.println(it.next());
		}*/
		
		/*List<Loan> loans = session.createQuery("from Loan where bankName=?")
								  .setFirstResult(0)
								  .setMaxResults(10)
								  .setParameter(0, "icbc")
								  .list();
		for(Loan loan:loans) {
			System.out.println(loan);
		}*/
		
		List<Loan> names = session.createQuery(
				"select new Loan(bankName,amount) from java.lang.Object")
							   .list();
		for(Loan n:names) {
			System.out.println(n.getBankName()+":"+n.getAmount());
		}
		
		Long count = (Long)session.createQuery("select count(*) from Loan").uniqueResult();
		System.out.println(count);
		
		session.close();
		
		//System.out.println(l.getBankName());
		
		factory.close();
	}

}
