package product;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.servlet.ModelAndView;

import common.Function;
import abstraction.SimpleDelegate;

public class SimpleProductDelegate extends SimpleDelegate{
	
	protected ProductDAO productDAO;
	
	public ProductDAO getProductDAO() {
		return productDAO;
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	public ModelAndView productList(HttpServletRequest request, HttpServletResponse response){

		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav, request);
		
		String searchKeyword = Function.nullChk(request.getParameter("searchKeyword"),"");
		String searchColumn = Function.nullChk(request.getParameter("searchColumn"),"");
		
		SimpleProduct sp = new SimpleProduct();
		
		if(!"".equals(searchColumn)){
			Method[] methods = SimpleProduct.class.getDeclaredMethods();
			
			for(Method m : methods){
				if(m.getName().equals(searchColumn)){
					try {
						//m.invoke(target, searchKeyword);
						m.invoke(sp, searchKeyword);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		List<SimpleProduct> list = productDAO.list(sp, 1, 500);
		long top = productDAO.count(sp); 
		
		mav.addObject("top",top);
		mav.addObject("searchColumn", searchColumn);
		mav.addObject("searchKeyword", searchKeyword);
		mav.addObject("productList", list);
		mav.addObject("leftName","/view/jsp/product/productList.jsp");
		mav.addObject("searchCondition","/view/jsp/product/searchCondition.jsp");
		mav.addObject("contentName","/view/jsp/product/productView.jsp");
		mav.addObject("ddNum","dd3");
		
		return mav;
	}
	
	public ModelAndView productView(HttpServletRequest request, HttpServletResponse response) throws IOException{

		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav, request);
		
		long articleId = Function.nullChk(request.getParameter("articleId"), 0);
		
		PrintWriter out = response.getWriter();
		
		SimpleProduct found = productDAO.read(SimpleProduct.class, articleId);
	
		JSONObject jsonObject=JSONObject.fromObject(found);

		out.println(jsonObject);
	    out.close();

		mav.addObject("contentName","/view/jsp/product/productView.jsp");
		
		return mav;
	}
	
	public ModelAndView productInsertPage(HttpServletRequest request, HttpServletResponse response){

		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav, request);
		
		String searchKeyword = Function.nullChk(request.getParameter("searchKeyword"),"");
		String searchColumn = Function.nullChk(request.getParameter("searchColumn"),"");
		
		SimpleProduct sp = new SimpleProduct();
		
		if(!"".equals(searchColumn)){
			Method[] methods = SimpleProduct.class.getDeclaredMethods();
			
			for(Method m : methods){
				if(m.getName().equals(searchColumn)){
					try {
						//m.invoke(target, searchKeyword);
						m.invoke(sp, searchKeyword);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			System.out.println("searchColumn" + searchColumn);
			System.out.println("searchKeyword" + searchKeyword);
			System.out.println("methods" + methods);
		}

		List<SimpleProduct> list = productDAO.list(sp, 1, 10000);
		
		mav.addObject("searchColumn", searchColumn);
		mav.addObject("searchKeyword", searchKeyword);
		mav.addObject("productList", list);
		mav.addObject("leftName","/view/jsp/product/productList.jsp");
		mav.addObject("searchCondition","/view/jsp/product/searchCondition.jsp");
		mav.addObject("contentName","/view/jsp/product/productInsert.jsp");
		
		return mav;
	}
	
	public ModelAndView productInsert(HttpServletRequest request, HttpServletResponse response) throws IOException{

		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav, request);
		
		String name = Function.nullChk(request.getParameter("name"), "");
		String company = Function.nullChk(request.getParameter("company"), "");
		int price = Function.nullChk(request.getParameter("price"), 0);
		
		SimpleProduct insertTarget = new SimpleProduct();
		insertTarget.setName(name);
		insertTarget.setCompany(company);
		insertTarget.setPrice(price);
		
		productDAO.create(insertTarget);
		
		mav.addObject("leftName","/view/jsp/product/productList.jsp");
		mav.addObject("contentName","/view/jsp/product/productInsert.jsp");
		
		return mav;
	}
	
	public ModelAndView productUpdate(HttpServletRequest request, HttpServletResponse response){

		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav, request);
		
		long articleId = Function.nullChk(request.getParameter("articleId"), 0);
		String name = Function.nullChk(request.getParameter("name"), "");
		String company = Function.nullChk(request.getParameter("company"), "");
		int price = Function.nullChk(request.getParameter("price"), 0);
		
		SimpleProduct found = productDAO.read(SimpleProduct.class, articleId);
		
		found.setName(name);
		found.setCompany(company);
		found.setPrice(price);
		
		productDAO.update(found);
		
		mav.addObject("contentName","/view/jsp/product/productView.jsp");
		
		return mav;
	}
	
	public ModelAndView productDelete(HttpServletRequest request, HttpServletResponse response){

		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav, request);
		
		long articleId = Function.nullChk(request.getParameter("articleId"), 0);
		
		SimpleProduct target = new SimpleProduct();
		target.setId(articleId);
		productDAO.delete(target);
		
		mav.addObject("contentName","/view/jsp/product/productView.jsp");
		
		return mav;
	}
	
}
