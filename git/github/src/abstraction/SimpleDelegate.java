package abstraction;

import javax.servlet.http.HttpServletRequest;


import org.springframework.web.servlet.ModelAndView;

public abstract class SimpleDelegate {
	
	public ModelAndView setDefaultViewSet(ModelAndView mav){
		mav.setViewName("/view/jsp/template/defaultView");
		mav.addObject("footerName", "/view/jsp/common/defaultFooter.jsp");
		mav.addObject("headName", "/view/jsp/common/defaultHead.jsp");
		mav.addObject("leftName", "/view/jsp/common/defaultLeft.jsp");
		mav.addObject("outerLeftName", "/view/jsp/common/defaultOuterLeft.jsp");
		return mav;
	}
	
	public ModelAndView setDefaultViewSet(ModelAndView mav, HttpServletRequest request){
		
/*		HttpSession session = request.getSession();

		if(session.getAttribute("userId")!=null){
			String userId = (String)session.getAttribute("userId");
			String [] name = userId.split("/");
			SimpleUsers mem = new SimpleUsers();
			mem = usersDAO.readCompany(SimpleUsers.class, name[0]);
			long articleId = mem.getId();
			SimpleBookmark bookmark = usersDAO.read(SimpleBookmark.class, articleId);
			
			mav.addObject("bookmark", bookmark);
		}*/
		mav.setViewName("/view/jsp/template/defaultView");
		mav.addObject("footerName", "/view/jsp/common/defaultFooter.jsp");
		mav.addObject("headName", "/view/jsp/common/defaultHead.jsp");
		mav.addObject("leftName", "/view/jsp/common/defaultLeft.jsp");
		mav.addObject("rightName", request.getAttribute("rightName"));
		mav.addObject("outerLeftName", "/view/jsp/common/defaultOuterLeft.jsp");
		return mav;
	}
}
