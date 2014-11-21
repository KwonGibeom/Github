package common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;
import org.springframework.web.servlet.mvc.multiaction.ParameterMethodNameResolver;

public class SimpleCustomParamMethodNameResolver extends
		ParameterMethodNameResolver {

	private String paramName = "list";
	private String defaultMethod;

	@Override
	public String getHandlerMethodName(HttpServletRequest request)
			throws NoSuchRequestHandlingMethodException {
		String name = "";

		try {
			name = request.getParameter(paramName);

			if (name == null) {
				name = defaultMethod;
			}

			if ("".equals(name)) {
				name = defaultMethod;
			}

			return name;

		} catch (Exception e) {

		}

		return name;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public void setDefaultMethod(String newDefaultMethod) {
		defaultMethod = newDefaultMethod;
		System.out.println("Default Method set to : " + defaultMethod);
	}
}
