package bookshop.action;

public class DeleteOrderDetailAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private Integer orderId;
	private Integer detailId;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getDetailId() {
		return detailId;
	}
	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}
	@Override
	public String execute() throws Exception {
		orderService.removeBook(orderId, detailId);
		return SUCCESS;
	}
	
}
