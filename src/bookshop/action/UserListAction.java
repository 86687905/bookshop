package bookshop.action;

import java.util.ArrayList;
import java.util.List;

import bookshop.domain.User;

public class UserListAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private static final Integer SIZE = 10;
	private Integer page;
	private Integer totalPage;
	private List<User> users = new ArrayList<User>();

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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@Override
	public String execute() throws Exception {
		Integer[] total = new Integer[1];
		page = page == null ? 1 : page;
		users = userService.getUserByPage((page - 1) * SIZE, SIZE, total);
		totalPage = total[0] % SIZE == 0 ? total[0] / SIZE : total[0] / SIZE + 1;
		return SUCCESS;
	}
}
