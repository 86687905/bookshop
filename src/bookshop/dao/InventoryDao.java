package bookshop.dao;

import bookshop.domain.Inventory;

public interface InventoryDao {

	public abstract void save(Inventory inventory);

	public abstract void delete(Inventory inventory);

	public abstract void deleteByUser(Integer userId);
	
	public abstract Inventory findById(Integer id);

	public abstract void update(Inventory inventory);
	
	public abstract void addBook(Integer userId, Integer bookId, Integer count);

	public abstract void removeBook(Integer inventoryId, Integer inventoryDetailId);

	public abstract Inventory getByUser(Integer id);

}