package bookshop.dao.impl;

import java.util.List;

import bookshop.dao.BookDao;
import bookshop.domain.Book;

import common.HibernateUtil;

public class BookDaoImpl implements BookDao {

	@Override
	public void save(Book book) {
		HibernateUtil.save(book);
	}

	@Override
	public void delete(Book book) {
		HibernateUtil.delete(book);
	}

	@Override
	public void deleteById(Integer id) {
		HibernateUtil.deleteById(Book.class, id);
	}

	@Override
	public Book findById(Integer id) {
		return (Book) HibernateUtil.get(Book.class, id);
	}

	@Override
	public void update(Book book) {
		HibernateUtil.update(book);
	}

	private List<Book> findByProperty(String property, Object value) {
		String hql = "from Book as model where model." + property + "= ?";
		return HibernateUtil.find(hql, value);
	}

	@Override
	public List<Book> findByIsbn(String isbn) {
		return findByProperty("isbn", isbn);
	}

	@Override
	public List<Book> findAll() {
		String hql = "from Book";
		return (List<Book>) HibernateUtil.find(hql);
	}

	@Override
	public List<Book> findByPage(int offset, int size, Integer[] total) {
		String hql = "from Book";
		return (List<Book>) HibernateUtil.findByPage(hql, offset, size, total);
	}
}
