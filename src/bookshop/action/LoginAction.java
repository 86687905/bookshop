package bookshop.action;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import bookshop.constant.CONSTANT;
import bookshop.domain.User;

import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Integer type;
	private String tip;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		User u = (User) session.get(CONSTANT.USER);
		if (u != null) {
			tip = "ÄúÒÑ¾­µÇÂ¼!";
			type = 0;
		} else {
			User[] user = new User[1];
			user[0] = new User();
			user[0].setUsername(username);
			user[0].setPassword(password);
			type = userService.login(user);
			switch (type) {
			case CONSTANT.MEMBER:
				Cookie c = new Cookie(CONSTANT.COOKIE, username + ":" + password);
				c.setMaxAge(60 * 60 * 24);
				ServletActionContext.getResponse().addCookie(c);
				session.put(CONSTANT.USER, user[0]);
				break;
			case CONSTANT.ADMIN:
				session.put(CONSTANT.USER, user[0]);
				break;
			case CONSTANT.FAIL:
				tip = "µÇÂ¼Ê§°Ü";
				break;
			case CONSTANT.NOUSER:
				tip = "ÓÃ»§²»´æÔÚ";
				break;
			case CONSTANT.WRONGPASSWORD:
				tip = "ÃÜÂë´íÎó";
				break;
			}
		}
		return SUCCESS;
	}

}
