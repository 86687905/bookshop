package bookshop.action;

import bookshop.constant.CONSTANT;
import bookshop.domain.User;

import com.opensymphony.xwork2.ActionContext;

public class InfoAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private String username;
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get(CONSTANT.USER);
		if (user != null) {
			username = user.getUsername();
			email = user.getEmail();
		}
		return SUCCESS;
	}

}
