package bookshop.service;

import bookshop.domain.Inventory;
import bookshop.domain.User;

public interface InventoryService {

	public abstract void addBook(Integer userId, Integer bookId, Integer count);

	public abstract void removeBook(Integer inventoryId, Integer inventoryDetailId);

	public abstract void setBookCount(Integer inventoryDetailId, Integer count);

	public abstract Inventory getByUser(User user);

}