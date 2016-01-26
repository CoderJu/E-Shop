package Junit.test;


import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class JpaTest {

	 @BeforeClass  
	    public static void setUpBeforeClass() throws Exception {  
	    }  
	  
	   /* @Test  
	    public void test() {  
	        EntityManagerFactory factory = Persistence.createEntityManagerFactory("eshop");  
	        EntityManager em = factory.createEntityManager();  
	        em.getTransaction().begin();  
	        em.persist(new TestBean());  
	        em.getTransaction().commit();  
	        em.close();  
	        factory.close();  
	    }  */
	 @Test
	 public void test() {
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		 DataSource dataSource  = (DataSource) ctx.getBean("dataSource");
		 System.out.println(dataSource);
	 }
}
