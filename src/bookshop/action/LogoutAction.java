package bookshop.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import bookshop.constant.CONSTANT;

public class LogoutAction extends BaseAction implements ServletRequestAware {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String execute() throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		Cookie c = new Cookie(CONSTANT.COOKIE, null);
		c.setMaxAge(0);
		ServletActionContext.getResponse().addCookie(c);
		return SUCCESS;
	}
}
