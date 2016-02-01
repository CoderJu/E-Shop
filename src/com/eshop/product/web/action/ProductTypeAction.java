package com.eshop.product.web.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.stereotype.Controller;

import com.eshop.base.PageView;
import com.eshop.base.bean.QueryResult;
import com.eshop.product.bean.ProductTypeBean;
import com.eshop.product.service.ProductTypeService;
import com.eshop.product.web.formbean.ProductTypeFormBean;


@Controller("/control/productManage/type/list")
public class ProductTypeAction extends Action {

	@Resource(name="productTypeServiceImpl")
	private ProductTypeService productTypeService;
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ProductTypeFormBean productTypeFormBean = (ProductTypeFormBean) form;
		List<Object> params = new ArrayList<Object>();
		StringBuffer jpql = new StringBuffer("o.visible=?1");
		params.add(true);
		System.out.println("++++++++"+productTypeFormBean.getPage());
		PageView<ProductTypeBean> pageView = new PageView<ProductTypeBean>(10, productTypeFormBean.getPage());
		int fristIndex = (pageView.getCurrentPage()-1)*pageView.getMaxResult();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("typeId", "desc");
		QueryResult<ProductTypeBean> qr =  productTypeService.getPagination(ProductTypeBean.class, 
				fristIndex, pageView.getMaxResult(),  params.toArray(), jpql.toString(),orderby);
		pageView.setQueryResult(qr);
		request.setAttribute("pageView", pageView);
		return mapping.findForward("list");

	}

	
}
