package bookshop.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import bookshop.domain.Book;

public class SaveBookAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String author;
	private String publish;
	private Date publishDate;
	private String isbn;
	private String description;
	private Double price;
	private File cover;
	private String coverContentType;
	private String coverFileName;
	private String savePath;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public File getCover() {
		return cover;
	}
	public void setCover(File cover) {
		this.cover = cover;
	}
	public String getCoverContentType() {
		return coverContentType;
	}
	public void setCoverContentType(String coverContentType) {
		this.coverContentType = coverContentType;
	}
	public String getCoverFileName() {
		return coverFileName;
	}
	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}
	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	@Override
	public String execute() throws Exception {
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setPublish(publish);
		book.setPublishDate(publishDate);
		book.setIsbn(isbn);
		book.setDescription(description);
		book.setPrice(price);
		book.setCover("book/"+id+"/"+coverFileName);
		if(id != null){
			book.setId(id);
			if (cover == null) {
				book.setCover(null);
			}
			bookService.updateBook(book);
		} else {			
			bookService.createBook(book);
		}
		if (cover != null) {
			String pathName = getSavePath() + "\\book\\" + id + "\\";
			File pathFile = new File(pathName);
			if (pathFile.exists() == false) {
				pathFile.mkdirs();
			}
			FileOutputStream fos = new FileOutputStream(pathName + coverFileName);
			FileInputStream fis = new FileInputStream(cover);

			byte[] buffer = new byte[1024 * 20];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			fos.close();
			fis.close();
		}
		return SUCCESS;
	}
	
}
