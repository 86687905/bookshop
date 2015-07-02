package bookshop.action;

import bookshop.constant.CONSTANT;
import bookshop.domain.User;

import com.opensymphony.xwork2.ActionContext;

public class UpdatePasswordAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private String password;
	private String password2;
	private Integer type;
	private String tip;
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
			tip = "两次输入密码不相同！";	
		}else{
			User user = (User)ActionContext.getContext().getSession().get(CONSTANT.USER);
			userService.updataUserPassword(user.getId(), password);
			type = 1;
			tip = "修改密码成功！";	
		}
		return SUCCESS;
	}
	
}
