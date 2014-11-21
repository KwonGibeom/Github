package bookmark;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import users.UsersDAO;

import common.Function;


import abstraction.SimpleDelegate;

public class SimpleBookmarkDelegate extends SimpleDelegate{
	
	protected UsersDAO usersDAO;
	
	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	
	public ModelAndView setDefaultViewSet(ModelAndView mav, HttpServletRequest request){
		
		mav.setViewName("/view/template/defaultView");
		mav.addObject("footerName", "/view/template/footer.jsp");
		mav.addObject("headName", "/view/template/head.jsp");
		mav.addObject("leftName", "/view/template/left.jsp");
		mav.addObject("rightName", "/view/template/right.jsp");

		return mav;
	}

	public ModelAndView bookmark(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		String url = Function.nullChk(request.getParameter("url"), "");
		long id = (Long) session.getAttribute("id");
		SimpleBookmark bookmark = new SimpleBookmark();
				
		if(usersDAO.read(SimpleBookmark.class, id)==null){ //null이면 생성
			bookmark.setId(id);
			usersDAO.create(bookmark);
		}
		
		List<SimpleBookmark> dl = usersDAO.list(bookmark,id);

		mav.addObject("list",dl);
		mav.addObject("url", url);
		mav.addObject("contentName","/view/bookmark/bookmarkPopup.jsp");
		
		setDefaultViewSet(mav, request);
		return mav;
	}
	
	public ModelAndView bookmarkUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		String url = Function.nullChk(request.getParameter("url"), "");
		int menu = Function.nullChk(request.getParameter("menu"), 0);
		long id = (Long) session.getAttribute("id");
		
		SimpleBookmark found = usersDAO.read(SimpleBookmark.class, id);

		switch (menu){
			case 1:
				found.setBookmark1(url);break;
			case 2:
				found.setBookmark2(url);break;
			case 3:
				found.setBookmark3(url);break;
			case 4:
				found.setBookmark4(url);break;
			case 5:
				found.setBookmark5(url);break;
			case 6:
				found.setBookmark6(url);break;
			case 7:
				found.setBookmark7(url);break;
			case 8:
				found.setBookmark8(url);break;
			case 9:
				found.setBookmark9(url);break;
			case 10:
				found.setBookmark10(url);break;
			default :
				break;
		}
		SimpleBookmark updated = usersDAO.update(found);
		
		mav.addObject("contentName",url);
		setDefaultViewSet(mav, request);
		return mav;
	}
	
}
