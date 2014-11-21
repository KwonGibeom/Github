/**
 * 
 */
package system.security;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * @author KwonGibeom/권기범
 * @date 2014. 11. 21.
 * @description
 * TODO TODO
 */
public class SimpleUserTracer implements UserTracer {

	StringBuilder sb; 
	
	
	/** (non-Javadoc)
	 * @see system.security.UserTracer#doTrace(javax.servlet.http.HttpServletRequest)
	 *
	 * @author KwonGibeom/권기범
	 * 2014. 11. 21.
	 * @description 
	 */
	public void doTrace(HttpServletRequest request){
		sb = new StringBuilder();
		sb.append("getRemoteAddr: " + request.getRemoteAddr() + " \n");
		sb.append("getRequestURI: " + request.getRequestURI() + " \n");
		sb.append("getRequestURL: " + request.getRequestURL() + " \n");
		sb.append("getServletPath: " + request.getServletPath() + " \n");
		sb.append("getQueryString: " + request.getQueryString() + " \n");
		
		System.out.println(sb.toString());
		
	}
	
	public String analyseUserAction(String queryString){
		return null;
	}
	
	public String extractTitle(HttpServletRequest request){
		
		String[] titles = {"accountName", "clsssKorName", "name", "title"};
		String title ="";
		Enumeration<String> paramNames = request.getParameterNames();
		
		String nextName = "";
		while(paramNames.hasMoreElements()){
			nextName = paramNames.nextElement();
			
			for(String t : titles){
				if(nextName.indexOf(t)>-1){
					title = request.getParameter(nextName);
				}
			}
			
		}
		
		return null;
	}
}
