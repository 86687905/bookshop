package bookshop.action;

public class DeleteListDetailAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Integer listId;
	private Integer detailId;
	private Integer type;
	private String tip;
	public Integer getListId() {
		return listId;
	}
	public void setListId(Integer listId) {
		this.listId = listId;
	}
	public Integer getDetailId() {
		return detailId;
	}
	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
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
		inventoryService.removeBook(listId, detailId);
		type = 1;
		tip = "ÒÑ¸üÐÂ";
		return SUCCESS;
	}
	
}
