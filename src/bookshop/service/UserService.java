package bookshop.service;

import java.util.List;

import bookshop.domain.User;

public interface UserService {

	public abstract int login(User[] user);

	public abstract boolean createUser(User user);

	public abstract boolean deleteUser(Integer id);

	public abstract boolean updateUser(User user);

	public abstract boolean updateUserByAdmin(User user);

	public abstract void updataUserPassword(Integer id, String password);

	public abstract User getUserDetail(Integer id);

	public abstract List<User> getUserList();

	public abstract List<User> getUserByPage(int offset, int size, Integer[] total);

}