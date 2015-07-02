package bookshop.action;

import java.util.ArrayList;
import java.util.List;

import bookshop.domain.Order;

public class OrderListAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static final Integer SIZE = 10;
	private Integer id;
	
	private Integer page;
	private Integer totalPage;
	private List<Order> orders = new ArrayList<Order>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
		public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String execute() throws Exception {
		Integer[] total = new Integer[1];
		page = page == null ? 1 : page;
		orders = orderService.getOrderByPage((page - 1) * SIZE, SIZE, total);
		totalPage = total[0] % SIZE == 0 ? total[0] / SIZE : total[0] / SIZE + 1;
		return SUCCESS;
	}
}
