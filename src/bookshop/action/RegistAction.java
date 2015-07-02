package bookshop.action;

import com.opensymphony.xwork2.ActionContext;

import bookshop.constant.CONSTANT;
import bookshop.domain.User;

public class RegistAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private String username;
	private String email;
	private String password;
	private String password2;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
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
		if(!password.equals(password2)){
			type = 0;
			tip = "两次输入密码不相同";
			return SUCCESS;
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(1);
		user.setEmail(email);
		if(!userService.createUser(user)){
			type = 0;
			tip = "用户名已存在";
		}else{
			type = 1;
			ActionContext.getContext().getSession().put(CONSTANT.USER, user);
		}
		return SUCCESS;
	}
	
}
