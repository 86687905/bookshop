package bookshop.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import bookshop.constant.CONSTANT;
import bookshop.domain.Order;
import bookshop.domain.User;

public class OrderAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private List<Order> orders = new ArrayList<Order>();
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String execute() throws Exception {
		User user = (User) ActionContext.getContext().getSession().get(CONSTANT.USER);
		if (user != null ) {
			orders = orderService.getOrderByUser(user.getId());
		}
		return SUCCESS;
	}
	
}
