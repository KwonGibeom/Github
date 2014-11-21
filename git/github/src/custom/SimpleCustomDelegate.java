package custom;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.servlet.ModelAndView;

import common.Function;

import abstraction.IDValuePair;
import abstraction.SimpleDelegate;

public class SimpleCustomDelegate extends SimpleDelegate{
	
	protected CustomDAO customDAO;
	
	public CustomDAO getcustomDAO() {
		return customDAO;
	}

	public void setCustomDAO(CustomDAO customDAO) {
		this.customDAO = customDAO;
	}
	
	public ModelAndView customList(HttpServletRequest request, HttpServletResponse response){

		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav, request);
		
		String searchKeyword = Function.nullChk(request.getParameter("searchKeyword"),"");
		String searchColumn = Function.nullChk(request.getParameter("searchColumn"),"");
		
		SimpleCustom sp = new SimpleCustom();
		
		if(!"".equals(searchColumn)){
			Method[] methods = SimpleCustom.class.getDeclaredMethods();
			
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

		List<SimpleCustom> list = customDAO.list(sp, 1, 1000);
		long top = customDAO.count(sp); 
		
		mav.addObject("top",top);
		mav.addObject("searchColumn", searchColumn);
		mav.addObject("searchKeyword", searchKeyword);
		mav.addObject("customList", list);
		mav.addObject("leftName","/view/jsp/custom/customList.jsp");
		mav.addObject("searchCondition","/view/jsp/custom/searchCondition.jsp");
		mav.addObject("contentName","/view/jsp/custom/customView.jsp");
		mav.addObject("ddNum","dd4");
		
		return mav;
	}
	
	public ModelAndView customView(HttpServletRequest request, HttpServletResponse response) throws IOException{

		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav, request);
		
		long articleId = Function.nullChk(request.getParameter("articleId"), 0);
		
		PrintWriter out = response.getWriter();
		
		SimpleCustom found = customDAO.read(SimpleCustom.class, articleId);
	
		JSONObject jsonObject=JSONObject.fromObject(found);

		out.println(jsonObject);
	    out.close();

		mav.addObject("contentName","/view/jsp/custom/customView.jsp");
		
		return mav;
	}
	
	public ModelAndView customInsertPage(HttpServletRequest request, HttpServletResponse response){

		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav, request);
		
		String searchKeyword = Function.nullChk(request.getParameter("searchKeyword"),"");
		String searchColumn = Function.nullChk(request.getParameter("searchColumn"),"");
		
		SimpleCustom sp = new SimpleCustom();
		
		if(!"".equals(searchColumn)){
			Method[] methods = SimpleCustom.class.getDeclaredMethods();
			
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

		List<SimpleCustom> list = customDAO.list(sp, 1, 10000);
		
		mav.addObject("searchColumn", searchColumn);
		mav.addObject("searchKeyword", searchKeyword);
		mav.addObject("customList", list);
		mav.addObject("leftName","/view/jsp/custom/customList.jsp");
		mav.addObject("searchCondition","/view/jsp/custom/searchCondition.jsp");
		mav.addObject("contentName","/view/jsp/custom/customInsert.jsp");
		
		return mav;
	}
	
	public ModelAndView customInsert(HttpServletRequest request, HttpServletResponse response) throws IOException{

		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav, request);
		
		String custNum = Function.nullChk(request.getParameter("custNum"), "");
		String custName = Function.nullChk(request.getParameter("custName"), "");
		String ownerName = Function.nullChk(request.getParameter("ownerName"), "");
		String custMail = Function.nullChk(request.getParameter("custMail"), "");
		String custTel = Function.nullChk(request.getParameter("custTel"), "");
		String custFax = Function.nullChk(request.getParameter("custFax"), "");
		String custEmp1 = Function.nullChk(request.getParameter("custEmp1"), "");
		String custEmp2 = Function.nullChk(request.getParameter("custEmp2"), "");
		String custEmp3 = Function.nullChk(request.getParameter("custEmp3"), "");
		String empTel1 = Function.nullChk(request.getParameter("empTel1"), "");
		String empTel2 = Function.nullChk(request.getParameter("empTel2"), "");
		String empTel3 = Function.nullChk(request.getParameter("empTel3"), "");
		
		SimpleDateFormat parser = new SimpleDateFormat("yyyyMMdd");
		Date today = new Date();
		String addDate = String.valueOf(parser.format(today));
		
		SimpleCustom insertTarget = new SimpleCustom();
		insertTarget.setCustNum(custNum);
		insertTarget.setCustName(custName);
		insertTarget.setOwnerName(ownerName);
		insertTarget.setCustMail(custMail);
		insertTarget.setCustTel(custTel);
		insertTarget.setCustFax(custFax);
		insertTarget.setCustEmp1(custEmp1);
		insertTarget.setCustEmp2(custEmp2);
		insertTarget.setCustEmp3(custEmp3);
		insertTarget.setEmpTel1(empTel1);
		insertTarget.setEmpTel2(empTel2);
		insertTarget.setEmpTel3(empTel3);
		insertTarget.setAddDate(addDate);
		insertTarget.setStopFlag("0");
		insertTarget.setStopDate("");
		
		customDAO.create(insertTarget);
		
		mav.addObject("leftName","/view/jsp/custom/customList.jsp");
		mav.addObject("contentName","/view/jsp/custom/customInsert.jsp");
		
		return mav;
	}
	
	public ModelAndView customUpdate(HttpServletRequest request, HttpServletResponse response){

		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav, request);
		
		long articleId = Function.nullChk(request.getParameter("articleId"), 0);
		String custNum = Function.nullChk(request.getParameter("custNum"), "");
		String custName = Function.nullChk(request.getParameter("custName"), "");
		String ownerName = Function.nullChk(request.getParameter("ownerName"), "");
		String custMail = Function.nullChk(request.getParameter("custMail"), "");
		String custTel = Function.nullChk(request.getParameter("custTel"), "");
		String custFax = Function.nullChk(request.getParameter("custFax"), "");
		String custEmp1 = Function.nullChk(request.getParameter("custEmp1"), "");
		String custEmp2 = Function.nullChk(request.getParameter("custEmp2"), "");
		String custEmp3 = Function.nullChk(request.getParameter("custEmp3"), "");
		String empTel1 = Function.nullChk(request.getParameter("empTel1"), "");
		String empTel2 = Function.nullChk(request.getParameter("empTel2"), "");
		String empTel3 = Function.nullChk(request.getParameter("empTel3"), "");
		
		System.out.println(articleId+custNum);
		
		SimpleCustom found = customDAO.read(SimpleCustom.class, articleId);
		found.setCustNum(custNum);
		found.setCustName(custName);
		found.setOwnerName(ownerName);
		found.setCustMail(custMail);
		found.setCustTel(custTel);
		found.setCustFax(custFax);
		found.setCustEmp1(custEmp1);
		found.setCustEmp2(custEmp2);
		found.setCustEmp3(custEmp3);
		found.setEmpTel1(empTel1);
		found.setEmpTel2(empTel2);
		found.setEmpTel3(empTel3);
		customDAO.update(found);
		
		mav.addObject("contentName","/view/jsp/custom/customView.jsp");
		
		return mav;
	}
	
	public ModelAndView customDelete(HttpServletRequest request, HttpServletResponse response){

		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav, request);
		
		long articleId = Function.nullChk(request.getParameter("articleId"), 0);
		
		SimpleCustom target = new SimpleCustom();
		target.setCustNo(articleId);
		customDAO.delete(target);
		
		mav.addObject("contentName","/view/jsp/custom/customView.jsp");
		
		return mav;
	}
	
}
