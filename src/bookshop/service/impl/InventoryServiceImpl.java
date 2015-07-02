package bookshop.service.impl;

import bookshop.domain.Inventory;
import bookshop.domain.InventoryDetail;
import bookshop.domain.User;
import bookshop.service.InventoryService;

public class InventoryServiceImpl extends BaseService implements InventoryService {

	@Override
	public void addBook(Integer userId, Integer bookId, Integer count) {
		inventoryDao.addBook(userId, bookId, count);
	}

	@Override
	public void removeBook(Integer inventoryId, Integer inventoryDetailId) {
		inventoryDao.removeBook(inventoryId, inventoryDetailId);
	}

	@Override
	public void setBookCount(Integer inventoryDetailId, Integer count) {
		InventoryDetail inventoryDetail = inventoryDetailDao.findById(inventoryDetailId);
		inventoryDetail.setCount(count < 0 ? 0 : count);
		inventoryDetailDao.update(inventoryDetail);
	}

	@Override
	public Inventory getByUser(User user){
		return inventoryDao.getByUser(user.getId());
	}
	public static void main(String[] args) {
		InventoryServiceImpl isi = new InventoryServiceImpl();
		isi.addBook(2, 1, 1);
		isi.addBook(2, 2, 2);
		isi.addBook(2, 3, 3);
		isi.addBook(2, 4, 4);
		isi.addBook(2, 5, 5);
	}
}
