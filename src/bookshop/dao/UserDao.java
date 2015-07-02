package bookshop.dao;

import java.util.List;

import bookshop.domain.User;

public interface UserDao {

	public abstract void save(User user);

	public abstract void delete(User user);

	public abstract void deleteById(Integer id);
	
	public abstract User findById(Integer id);

	public abstract void update(User user);

	public abstract List<User> findByUsername(String username);

	public abstract List<User> findAll();

	public abstract List<User> findByPage(int offset, int size, Integer[] total);

	

}