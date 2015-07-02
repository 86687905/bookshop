package bookshop.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import bookshop.constant.CONSTANT;
import bookshop.domain.User;
import bookshop.service.factory.ServiceFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AutoLoginInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;

	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(StrutsStatics.HTTP_REQUEST);

		Map<String, Object> session = ctx.getSession();
		if (session.get(CONSTANT.USER) != null) {
			return invocation.invoke();
		}
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (CONSTANT.COOKIE.equals(cookie.getName())) {
					String value = cookie.getValue();
					if (value != null) {
						String[] split = value.split(":");
						String username = split[0];
						String password = split[1];
						User[] user = new User[1];
						user[0] = new User();
						user[0].setUsername(username);
						user[0].setPassword(password);
						ServiceFactory.getInstance().getUserService().login(user);
						session.put(CONSTANT.USER, user[0]);
					}
					break;
				}
			}
		}
		return invocation.invoke();
	}

}
