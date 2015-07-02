package bookshop.action;

import bookshop.constant.CONSTANT;
import bookshop.domain.User;

import com.opensymphony.xwork2.ActionContext;

public class UpdateUserAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private String username;
	private String email;
	private Integer type;
	private String tip;

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
		User user = (User) ActionContext.getContext().getSession().get(CONSTANT.USER);
		if (user != null) {
			user.setUsername(username);
			user.setEmail(email);
			if (userService.updateUser(user)) {
				type = 1;
				tip = "修改成功！";
			} else {
				type = 0;
				tip = "用户名已存在！";
			}
		}
		return SUCCESS;
	}
}
