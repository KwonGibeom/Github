package users;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import users.Users;

import net.sf.json.JSONObject;

import org.springframework.web.servlet.ModelAndView;

import common.Function;

import abstraction.SimpleDelegate;

public class SimpleUsersDelegate extends SimpleDelegate{
	
	HashMap hs = new HashMap();
	protected UsersDAO usersDAO;
	
	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	
	public ModelAndView hello(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("massage", "menu1");
		mav.addObject("contentName","/view/jsp/helloSample.jsp");
		mav.addObject("ddNum","dd1");
		
		setDefaultViewSet(mav);
		return mav;
	}
	
	public ModelAndView usersList(HttpServletRequest request, HttpServletResponse response){

		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav, request);
		
		String searchKeyword = Function.nullChk(request.getParameter("searchKeyword"),"");
		String searchColumn = Function.nullChk(request.getParameter("searchColumn"),"");
		
		SimpleUsers sm = new SimpleUsers();
		
		if(!"".equals(searchColumn)){
			Method[] methods = SimpleUsers.class.getDeclaredMethods();
			
			for(Method m : methods){
				if(m.getName().equals(searchColumn)){
					try {
						//m.invoke(target, searchKeyword);
						m.invoke(sm, searchKeyword);
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

		List<SimpleUsers> list = usersDAO.list(sm, 1, 10000);
		
		mav.addObject("searchColumn", searchColumn);
		mav.addObject("searchKeyword", searchKeyword);
		mav.addObject("usersList", list);
		mav.addObject("leftName","/view/jsp/users/usersList.jsp");
		mav.addObject("searchCondition","/view/jsp/users/searchCondition.jsp");
		mav.addObject("contentName","/view/jsp/users/usersView.jsp");
		mav.addObject("ddNum","dd2");
		
		return mav;
	}
	
	public ModelAndView usersView(HttpServletRequest request, HttpServletResponse response) throws IOException{

		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav, request);
		
		long articleId = Function.nullChk(request.getParameter("articleId"), 0);
		
		PrintWriter out = response.getWriter();
		
		SimpleUsers found = usersDAO.read(SimpleUsers.class, articleId);
	
		JSONObject jsonObject=JSONObject.fromObject(found);

		out.println(jsonObject);
	    out.close();

		mav.addObject("contentName","/view/jsp/users/usersView.jsp");
		
		return mav;
	}
	
	public ModelAndView usersInsert(HttpServletRequest request, HttpServletResponse response){

		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav, request);
		
		List<Users> usersList = usersDAO.getList();
		
		mav.addObject("usersList", usersList);
		mav.addObject("leftName","/view/jsp/users/usersList.jsp");
		mav.addObject("contentName","/view/jsp/users/join.jsp");
		
		return mav;
	}
	
	public ModelAndView usersUpdate(HttpServletRequest request, HttpServletResponse response){

		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav, request);
		
		long articleId = Function.nullChk(request.getParameter("articleId"), 0);
		String userId = Function.nullChk(request.getParameter("userId"), "");
		long compNo = Function.nullChk(request.getParameter("compNo"), 0);
		String userName = Function.nullChk(request.getParameter("userName"), "");
		
		SimpleUsers found = usersDAO.read(SimpleUsers.class, articleId);
		
		found.setUserId(userId);
		found.setCompNo(compNo);
		found.setUserName(userName);
		
		usersDAO.update(found);
		
		mav.addObject("contentName","/view/jsp/users/usersView.jsp");
		
		return mav;
	}
	
	public ModelAndView usersDelete(HttpServletRequest request, HttpServletResponse response){

		ModelAndView mav = new ModelAndView();
		setDefaultViewSet(mav, request);
		
		long articleId = Function.nullChk(request.getParameter("articleId"), 0);
		
		SimpleUsers target = new SimpleUsers();
		target.setId(articleId);
		usersDAO.delete(target);
		
		mav.addObject("contentName","/view/jsp/users/usersView.jsp");
		
		return mav;
	}
	
	public ModelAndView usersJoinPage(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mav = new ModelAndView();

		mav.addObject("contentName","/view/jsp/users/join.jsp");
		
		setDefaultViewSet(mav);
		return mav;
	}
	
	public void usersJoin(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String userName = Function.nullChk(request.getParameter("userName"), "");
		long compNo = Function.nullChk(request.getParameter("compNo"), 0);
		String userId = Function.nullChk(request.getParameter("userId"), "");
		String userPass = Function.nullChk(request.getParameter("userPass"), "");
		
		HttpSession session = request.getSession();
		long id = (Long) session.getAttribute("id");
		
		String check = Function.nullChk(request.getParameter("authentication"), "");
		
		PrintWriter out = null;
		
		response.setContentType("text/html;charset=utf-8");
		out = response.getWriter();
		
		String authentication = (String) hs.get(id);
		if(authentication.equals(check)){
			
			SimpleUsers insertTarget = new SimpleUsers();
			insertTarget.setUserName(userName);
			insertTarget.setCompNo(compNo);
			insertTarget.setUserId(userId);
			insertTarget.setUserPass(userPass);
			
			usersDAO.create(insertTarget);
			
			out.println("<script language=javascript>");
			out.println("alert('회원 가입완료.');");
			out.println("location.href = 'users.do?action=usersList'");
			out.println("</script>");
		}else{
			out.println("<script language=javascript>");
			out.println("alert('메일 인증에 실패했습니다.');");
			out.println("location.href = 'users.do?action=usersJoinPage'");
			out.println("</script>");       	
		}
		
	}
	
	public void mailConfirm(HttpServletRequest request, HttpServletResponse response){
		
		PrintWriter out = null;

		String userId = Function.nullChk(request.getParameter("userId"), "");	
		boolean chk = false;
		
		String d_email = "hfplatform.kfri.re.kr@gmail.com";
	    String d_password = "dkswldbs";
	    String d_uname = "";
	    String d_host = "smtp.gmail.com";
	    String d_port  = "465";
				
		Properties p = new Properties();
			p.put("mail.smtp.starttls.enable","true");
			p.put("mail.smtp.user", d_email);
			p.put("mail.smtp.host", d_host);
			p.put("mail.smtp.port", d_port);
			p.put( "mail.smtp.auth", "true");

			p.put("mail.smtp.debug", "true");
			p.put("mail.smtp.socketFactory.port", d_port); 
			p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
			p.put("mail.smtp.socketFactory.fallback", "false"); 

		  //Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

		try {
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
			
		    Authenticator auth = new SMTPAuthenticator();
		    Session mailSession = Session.getInstance(p, auth);
		    //mailSession.setDebug(true);

		   //session = Session.getDefaultInstance(p);
		    MimeMessage msg = new MimeMessage(mailSession);
		    
		    HttpSession session = request.getSession();
			long id = (Long) session.getAttribute("id");
		    hs = issue(id);
		    
		    String authentication = (String) hs.get(id);
		    
		    String message = "인증번호는  "+authentication+" 입니다.";
		    msg.setSubject("메일 인증번호 발급");
		    
		    msg.setContent(message, "text/plain;charset=KSC5601");
		    System.out.println("Message: " + msg.getContent());
		    
		    Address fromAddr = new InternetAddress(d_email); // 보내는 사람의 메일주소
		    Address toAddr = new InternetAddress(userId);  // 받는 사람의 메일주소
		    
		    msg.setFrom(fromAddr);
		    msg.addRecipient(Message.RecipientType.TO, toAddr); 
		  
		    Transport transport = mailSession.getTransport("smtp");
            transport.connect(d_host, Integer.valueOf(d_port), d_uname, d_password);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
            chk = true;
            out.println(chk);
            out.close();
		}catch (Exception mex) {
		    mex.printStackTrace(); 
		}

	}
	
	protected static class SMTPAuthenticator extends javax.mail.Authenticator {

		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("hfplatform.kfri.re.kr","dkswldbs");
		  }
	} 
	
	private HashMap issue(long id){
		int codeLength = 6;
		StringBuffer sb = new StringBuffer();
		String res = null;
		for (int i = 0; i < codeLength; i++) {
			//String res = null;
			int isChar = (int) (Math.random() * 2);
			
			if (isChar == 0) {
				res = String.valueOf((char) (Math.random() * 26 + 65));
			}else{
				res = String.valueOf((int) (Math.random() * 9));
			}
			sb.append(res);
		}
		hs.put(id, sb.toString());
		
		return hs;
		
	}
	
}
