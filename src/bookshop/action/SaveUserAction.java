package bookshop.action;

import bookshop.domain.User;

public class SaveUserAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String username;
	private String email;
	private Integer role;
	private String tip;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	@Override
	public String execute() throws Exception {
		User user = new User();
		if(id != null){
			user.setId(id);
			user.setRole(role);
			user.setUsername(username);
			user.setEmail(email);
			if (userService.updateUserByAdmin(user)) {
				tip = "修改成功！";
			} else {
				tip = "用户名已存在！";
			}
		} else {
			user.setRole(role);
			user.setUsername(username);
			user.setEmail(email);
			user.setPassword(username);
			if (userService.createUser(user)){
				tip = "修改成功！";
			} else {
				tip = "用户名已存在！";
			}
		}
		return SUCCESS;
	}

}
