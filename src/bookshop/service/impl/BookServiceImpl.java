package bookshop.service.impl;

import java.util.List;

import bookshop.domain.Book;
import bookshop.service.BookService;

public class BookServiceImpl extends BaseService implements BookService {

	@Override
	public boolean createBook(Book book) {
		List<Book> list = bookDao.findByIsbn(book.getIsbn());
		if (list.size() > 0) {
			return false;
		}
		bookDao.save(book);
		return true;
	}

	@Override
	public boolean deleteBook(Integer id) {
		try {
			bookDao.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void updateBook(Book book) {
		Book oldbook = bookDao.findById(book.getId());
		oldbook.setName(book.getName());
		oldbook.setAuthor(book.getAuthor());
		oldbook.setPublish(book.getPublish());
		oldbook.setPublishDate(book.getPublishDate());
		oldbook.setIsbn(book.getIsbn());
		oldbook.setDescription(book.getDescription());
		oldbook.setPrice(book.getPrice());
		if(book.getCover() != null){
			oldbook.setCover(book.getCover());
		}
		bookDao.update(oldbook);
	}

	@Override
	public Book getBookDetail(Integer id) {
		return bookDao.findById(id);
	}

	@Override
	public List<Book> getBookList() {
		return bookDao.findAll();
	}

	@Override
	public List<Book> getBookByPage(int offset, int size, Integer[] total) {
		return bookDao.findByPage(offset, size, total);
	}
}
