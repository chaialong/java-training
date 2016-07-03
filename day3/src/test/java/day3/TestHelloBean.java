package day3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.day3.spring.HelloBean;
import com.training.day3.spring.MyFactoryBean;

public class TestHelloBean {

	@Test
	public void test() {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring.xml");
		
		HelloBean bean = context.getBean("hello", HelloBean.class);
		HelloBean bean1 = context.getBean("hello", HelloBean.class);
		Object my = context.getBean("&my");
		
		System.out.println(my);
	}

}








