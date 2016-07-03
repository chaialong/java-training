package day2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

import com.training.vo.Student;
import com.training.vo.Teacher;

public class TestStudent {

	@Test
	public void test() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.xml")
																			   .build();
		Metadata meta = new MetadataSources(registry).buildMetadata();
		SessionFactory factory = meta.buildSessionFactory();
		Session session = factory.openSession();
		
		session.get(Student.class, 2);
		
		
		/*Student s1 = session.get(Student.class, 2);
		System.out.println(s1.getTeacher().getName());*/
		
		/*List<Student> stus = session.createQuery("from Student s left join fetch s.teacher")
									.list();
		for(Student s:stus) {
			System.out.println(s.getTeacher().getName());
		}*/
		
		/*Student s2 = (Student) session.createQuery("from Student s left join fetch s.teacher where s.id=2")
									  .uniqueResult();
		System.out.println(s2.getTeacher().getName());*/
		
		/*Teacher t1 = session.get(Teacher.class, 2);
		System.out.println(t1.getStudent().getName());*/
		Teacher t1 = session.get(Teacher.class, 2);
		System.out.println(t1.getStudents().getClass());
		for(Student s:t1.getStudents()) {
			System.out.println(s);
		}
		
		session.close();
		factory.close();
		
	}

}
