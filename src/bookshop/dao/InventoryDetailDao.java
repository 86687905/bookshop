package bookshop.dao;

import bookshop.domain.InventoryDetail;

public interface InventoryDetailDao {

	public abstract void save(InventoryDetail inventoryDetail);

	public abstract void delete(InventoryDetail inventoryDetail);

	public abstract void deleteById(Integer id);
	
	public abstract InventoryDetail findById(Integer id);

	public abstract void update(InventoryDetail inventoryDetail);

}