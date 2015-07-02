package bookshop.dao;

import java.util.List;

import bookshop.domain.Book;

public interface BookDao {

	public abstract void save(Book book);

	public abstract void delete(Book book);

	public abstract void deleteById(Integer id);

	public abstract Book findById(Integer id);

	public abstract void update(Book book);

	public abstract List<Book> findByIsbn(String isbn);

	public abstract List<Book> findAll();

	public abstract List<Book> findByPage(int offset, int size, Integer[] total);

}