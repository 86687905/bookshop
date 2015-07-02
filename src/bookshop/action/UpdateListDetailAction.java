package bookshop.action;

public class UpdateListDetailAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Integer Id;
	private Integer count;
	private Integer type;
	private String tip;

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
		inventoryService.setBookCount(Id, count);
		type = 1;
		tip = "ÒÑ¸üÐÂ";
		return SUCCESS;
	}

}
