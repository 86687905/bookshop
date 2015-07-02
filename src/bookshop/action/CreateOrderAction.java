package bookshop.action;

import java.util.Date;

import bookshop.domain.Order;

public class CreateOrderAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private Date orderDate;
	private Date checkoutDate;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	@Override
	public String execute() throws Exception {
		Order order = new Order();
		order.setTotalPrice(0.0);
		order.setUser(userService.getUserDetail(userId));
		order.setOrderDate(orderDate);
		order.setCheckoutDate(checkoutDate);	
		orderService.createOrder(order);
		return SUCCESS;
	}
	
}
