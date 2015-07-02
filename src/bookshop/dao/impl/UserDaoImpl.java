package bookshop.dao.impl;

import java.util.List;

import bookshop.dao.UserDao;
import bookshop.domain.User;

import common.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public void save(User user) {
		HibernateUtil.save(user);
	}

	@Override
	public void delete(User user) {
		HibernateUtil.delete(user);
	}

	@Override
	public void deleteById(Integer id) {
		HibernateUtil.deleteById(User.class, id);
	}

	@Override
	public User findById(Integer id) {
		return (User) HibernateUtil.get(User.class, id);
	}

	@Override
	public void update(User user) {
		HibernateUtil.update(user);
	}

	private List<User> findByProperty(String property, Object value) {
		String hql = "from User as model where model." + property + "= ?";
		return (List<User>) HibernateUtil.find(hql, value);
	}

	@Override
	public List<User> findByUsername(String username) {
		return findByProperty("username", username);
	}
	
	@Override
	public List<User> findAll() {
		String hql = "from User";
		return (List<User>) HibernateUtil.find(hql);
	}

	@Override
	public List<User> findByPage(int offset, int size, Integer[] total) {
		String hql = "from User";
		return (List<User>) HibernateUtil.findByPage(hql, offset, size, total);
	}
	public static void main(String[] args) {
		UserDaoImpl udi = new UserDaoImpl();
		List<User> list = udi.findByUsername("member");
		System.out.println(list.get(0).getEmail());
		System.out.println(list.get(0).getId());
	}
}
