/**
 * 
 */
package system.security;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Function;
import users.UsersDAO;
import users.SimpleUsers;
import system.security.LoginManager;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author 
 * @date 2014. 11. 21.
 * @description
 * TODO TODO
 */
public class AuthenticatorDelegate extends abstraction.SimpleDelegate{
	
	protected UsersDAO usersDAO;
	
	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	private LoginManager loginManager;
	
	public LoginManager getLoginManager() {
		return loginManager;
	}

	public void setLoginManager(LoginManager loginManager) {
		this.loginManager = loginManager;
	}

	public ModelAndView authenticateUsersPage(HttpServletRequest request, HttpServletResponse respnse){
		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav);
		mav.addObject("contentName","/view/jsp/helloSample.jsp");
		mav.addObject("rightName","/view/jsp/common/defaultRight.jsp");
		return mav;
	}

	public void logout(HttpServletRequest request, HttpServletResponse respnse) throws IOException{
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		respnse.sendRedirect("authenticator.do?action=authenticateUsersPage");
		
	}
	
	public void loginTry(HttpServletRequest request, HttpServletResponse respnse) throws IOException{
		
		LoginManager loginManager = LoginManager.getInstance(); 
		String userId = Function.nullChk(request.getParameter("userId"), "");
		String userPw = Function.nullChk(request.getParameter("userPw"), "");
		
		PrintWriter out = null;
		
		respnse.setContentType("text/html;charset=utf-8");
		out = respnse.getWriter();		
		
		if ( (usersDAO.authenticate(userId, userPw, 2))!=null ){
			SimpleUsers mem = new SimpleUsers();
			mem = usersDAO.readCompany(SimpleUsers.class, userId);
			String userName = mem.getUserName();
			long company = mem.getCompNo();
			long id = mem.getId();

			HttpSession session = request.getSession();
	        //접속자 아이디를 세션에 담는다.
	        session.setAttribute("userId", userId+"/"+company);
	        session.setAttribute("name", userName);
	        session.setAttribute("email", userId);
	        session.setAttribute("id", id);
	        //이미 접속한 아이디인지 체크한다.
	        loginManager.printloginUsers();	        
	        
	        if(loginManager.isUsing(userId+"/"+company)){
	        	out.println("<script language=javascript>");
				out.println("if(confirm('이미 접속중입니다. 기존의 접속을 종료하시겠습니까?')){;");
				out.println("location.href = 'authenticator.do?action=disconnect'");
				out.println("}else{");
				out.println("location.href = 'authenticator.do?action=authenticateUsersPage'");
				out.println("}</script>");        	
	        }else{	        	
	            loginManager.setSession(session, userId+"/"+company);
	            respnse.sendRedirect("authenticator.do?action=loginOk");     
	        }
		}else{
			out.println("<script language=javascript>");
			out.println("alert('로그인 정보가 없습니다.');");
			out.println("location.href = 'authenticator.do?action=authenticateUsersPage'");
			out.println("</script>");
	    }
		
	}
	
	public void disconnect(HttpServletRequest request, HttpServletResponse respnse) throws IOException{
		
		LoginManager loginManager = LoginManager.getInstance();
		HttpSession session = request.getSession();
		
		String userId = (String)session.getAttribute("userId");

		 if(userId != null){
		    //기존의 접속(세션)을 끊는다.
		    loginManager.removeSession(userId);

		    //새로운 세션을 등록한다. setSession함수를 수행하면 valueBound()함수가 호출된다.
		    loginManager.setSession(session, userId);
		    respnse.sendRedirect("authenticator.do?action=loginOk");    
		 }
		
	}
	
	public ModelAndView loginOk(HttpServletRequest request, HttpServletResponse respnse) throws IOException{
		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav);

		LoginManager loginManager = LoginManager.getInstance();
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		
		String [] name = userId.split("/");
    	int companyCount = loginManager.isUsingCount(name[1]);
    	
		if(companyCount > 2){
			//session.invalidate();
			respnse.sendRedirect("authenticator.do?action=authenticateUsersPage");
    	}
		
	    if(userId != null){
	    	mav.addObject("returnURL","users.do?action=hello");
			mav.addObject("contentName","/view/jsp/helloSample.jsp");
			mav.addObject("rightName","/view/jsp/users/login_ok.jsp");
	    }
		return mav;
	}
	
}
