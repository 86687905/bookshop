package bookshop.service;

import java.util.List;

import bookshop.domain.Book;

public interface BookService {

	public abstract boolean createBook(Book book);

	public abstract boolean deleteBook(Integer id);

	public abstract void updateBook(Book book);

	public abstract Book getBookDetail(Integer id);

	public abstract List<Book> getBookList();

	public abstract List<Book> getBookByPage(int offset, int size, Integer[] total);

}