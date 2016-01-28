package Junit.test.product;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.eshop.product.bean.ProductTypeBean;
import com.eshop.product.service.ProductTypeService;

public class ProductTypeTest {

	private static ProductTypeService productTypeService;
	private static ApplicationContext ctx;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ctx = new ClassPathXmlApplicationContext("beans.xml");
			productTypeService = (ProductTypeService) ctx.getBean("productTypeServiceImpl");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSave() {
		for (int i = 0; i < 20; i++) {
		ProductTypeBean productTypeBean = new ProductTypeBean();
		productTypeBean.setName(i+"篮球");
		productTypeBean.setNote(i+"NBA专用篮球");
		productTypeService.save(productTypeBean);
		}
	}

	@Test
	public void testDelete() {
		productTypeService.delete(ProductTypeBean.class, 1);
	}

	@Test
	public void testUpdate() {
		ProductTypeBean productTypeBean = productTypeService.query(ProductTypeBean.class, 1);
		productTypeBean.setName("足球");
		productTypeBean.setNote("足球之家");
		productTypeService.update(productTypeBean);
	}

	@Test
	public void testQuery() {
		ProductTypeBean productTypeBean = productTypeService.query(ProductTypeBean.class, 1);
		System.out.println(productTypeBean.getName());
		System.out.println(productTypeBean.getNote());

	}

}
