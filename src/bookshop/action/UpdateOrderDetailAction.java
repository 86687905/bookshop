package bookshop.action;

public class UpdateOrderDetailAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Integer Id;
	private Integer count;
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String execute() throws Exception {
		orderService.setBookCount(Id, count);
		return SUCCESS;
	}

}
