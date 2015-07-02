package bookshop.action;

public class DeleteUserAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		userService.deleteUser(id);
		return SUCCESS;
	}
}
