/**
 * 
 */
package system.security;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import users.Users;
import users.UsersDAO;

/**
 * @author KwonGibeom/권기범
 * @date 2014. 11. 21.
 * @description
 * TODO TODO
 */
/**
 * @author KwonGibeom/권기범
 * @date 2014. 11. 21.
 * @description
 * TODO TODO
 */
public class SecurityFilter implements Filter{

	private UserTracer userTracer;
	private UsersDAO usersDAO;
	
	
	
	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}

	public UserTracer getUserTracer() {
		return userTracer;
	}

	public void setUserTracer(UserTracer userTracer) {
		this.userTracer = userTracer;
	}

	/** (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 *
	 * @author KwonGibeom/권기범
	 * 2014. 11. 21.
	 * @description 
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/** (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 *
	 * @author KwonGibeom/권기범
	 * 2014. 11. 21.
	 * @description 
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Spring filter :)");
		
		userTracer.doTrace((HttpServletRequest) servletRequest);
		
		String id = "";
		String password = "";
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
		
		if(isLogin(servletRequest)){
			httpServletRequest.setAttribute("rightName", "/view/jsp/users/login_ok.jsp");
			filterChain.doFilter(servletRequest,servletResponse);
			
		}else{
			httpServletRequest.setAttribute("rightName", "/view/jsp/common/defaultRight.jsp");
			httpServletRequest.getRequestDispatcher("authenticator.do?action=authenticateUsersPage").forward(httpServletRequest, httpServletResponse);
		}		
	}

	/** (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 *
	 * @author KwonGibeom/권기범
	 * 2014. 11. 21.
	 * @description 
	 */
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	private boolean isLogin(ServletRequest servletRequest){
		boolean isLogin = false;
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		System.out.println("isLogin ? ");
		
		String servletPath = request.getServletPath();
		String url = request.getQueryString();
		
		if(url == null){
			url = "";
		}
		
		System.out.println("  " + servletPath+" "+url);

		if(("/authenticator.do".equals(servletPath))){		
			System.out.println("bypassing security filter to authenticate first");
			return true;
		}else{
			
				isLogin = sessionCheck(servletRequest);
			}
			
			return isLogin;	
		}
		

	
	public boolean sessionCheck(ServletRequest servletRequest){
		
		boolean result = false;
		String sessionUserId = "";
		HttpServletRequest request = (HttpServletRequest)servletRequest;
		HttpSession session = request.getSession();
		
		if(session!=null){
			System.out.println("isLogin ? session!=null ");
			Object obj =session.getAttribute("userId");

			if(obj!=null ){//&& obj instanceof Users ){
				System.out.println("isLogin ? obj!=null ");

				//Users m = (Users)obj;
				//sessionUserId = m.getName();
				//if(!"".equals(sessionUserId.trim())){
				if(!"".equals(((String) obj).trim())){
					result = true;
				}
			}
			
		}
		
		return result;
	}
	
}
