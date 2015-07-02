package bookshop.action;

import bookshop.domain.Book;

public class BookDetailAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Book book;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String execute() throws Exception {
		book = bookService.getBookDetail(id);
		return SUCCESS;
	}
	
}
