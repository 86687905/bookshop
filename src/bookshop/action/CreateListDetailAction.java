package bookshop.action;

import bookshop.constant.CONSTANT;
import bookshop.domain.User;

import com.opensymphony.xwork2.ActionContext;

public class CreateListDetailAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer count;
	private Integer type;
	private String tip;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
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
		User user = (User)ActionContext.getContext().getSession().get(CONSTANT.USER);
		if(user != null){
			inventoryService.addBook(user.getId(), id, count);
			type = 1;
			tip = "成功加入清单";
		}else {
			type = 0;
			tip = "您还没有登录，请先登录再进行操作！";
		}
		return SUCCESS;
	}
	
}
