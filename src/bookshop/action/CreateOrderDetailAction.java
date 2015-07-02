package bookshop.action;

public class CreateOrderDetailAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Integer orderId;
	private Integer bookId;
	private Integer count;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String execute() throws Exception {
		orderService.addBook(orderId, bookId, count);
		return SUCCESS;
	}

}
