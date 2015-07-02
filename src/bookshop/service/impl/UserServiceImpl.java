package bookshop.service.impl;

import java.util.List;

import bookshop.constant.CONSTANT;
import bookshop.domain.User;
import bookshop.service.UserService;

import common.StringUtil;

public class UserServiceImpl extends BaseService implements UserService {
	@Override
	public int login(User[] user) {
		List<User> list = (List<User>) userDao.findByUsername(user[0].getUsername());
		if (list.size() == 0) {
			return CONSTANT.NOUSER;
		}
		User u = list.get(0);
		if (StringUtil.encrypt(user[0].getPassword()).equals(u.getPassword())) {
			user[0] = u;
			switch (u.getRole()) {
			case 0:
				return CONSTANT.ADMIN;
			case 1:
				return CONSTANT.MEMBER;
			default:
				return CONSTANT.FAIL;
			}
		} else {
			return CONSTANT.WRONGPASSWORD;
		}
	}

	@Override
	public boolean createUser(User user) {
		List<User> list = userDao.findByUsername(user.getUsername());
		if (list.size() > 0) {
			return false;
		}
		user.setPassword(StringUtil.encrypt(user.getPassword()));// ¼ÓÃÜÃÜÂë
		userDao.save(user);
		return true;
	}

	@Override
	public boolean deleteUser(Integer id) {
		try {
			userDao.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		User olduser = userDao.findById(user.getId());
		if (olduser.getUsername().equals(user.getUsername())) {
			userDao.update(user);
			return true;
		} else if (userDao.findByUsername(user.getUsername()).size() > 0) {
			return false;
		} else {
			userDao.update(user);
			return true;
		}
	}

	@Override
	public boolean updateUserByAdmin(User user) {
		User olduser = userDao.findById(user.getId());
		if (olduser.getUsername().equals(user.getUsername())) {
			user.setPassword(olduser.getPassword());
			userDao.update(user);
			return true;
		} else if (userDao.findByUsername(user.getUsername()).size() > 0) {
			return false;
		} else {
			user.setPassword(olduser.getPassword());
			userDao.update(user);
			return true;
		}
	}

	@Override
	public void updataUserPassword(Integer id, String password) {
		User user = userDao.findById(id);
		user.setPassword(StringUtil.encrypt(password));
		userDao.update(user);
	}

	@Override
	public User getUserDetail(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public List<User> getUserList() {
		return userDao.findAll();
	}

	@Override
	public List<User> getUserByPage(int offset, int size, Integer[] total) {
		return userDao.findByPage(offset, size, total);
	}
}
