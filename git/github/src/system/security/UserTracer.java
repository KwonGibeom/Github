/**
 * 
 */
package system.security;

import javax.servlet.http.HttpServletRequest;

/**
 * @author KwonGibeom/권기범
 * @date 2014. 11. 21.
 * @description
 * TODO TODO
 */
public interface UserTracer {

	public abstract void doTrace(HttpServletRequest request);

}