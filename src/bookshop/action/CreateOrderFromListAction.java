package bookshop.action;

import bookshop.constant.CONSTANT;
import bookshop.domain.User;

import com.opensymphony.xwork2.ActionContext;

public class CreateOrderFromListAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		User user = (User)ActionContext.getContext().getSession().get(CONSTANT.USER);
		orderService.createOrder(user.getId());
		return SUCCESS;
	}
	
}
