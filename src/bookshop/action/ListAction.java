package bookshop.action;

import bookshop.constant.CONSTANT;
import bookshop.domain.Inventory;
import bookshop.domain.User;

import com.opensymphony.xwork2.ActionContext;

public class ListAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Inventory list;

	public Inventory getList() {
		return list;
	}

	public void setList(Inventory list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get(CONSTANT.USER);
		if (user != null ) {
			list = inventoryService.getByUser(user);
		}
		return SUCCESS;
	}

}
