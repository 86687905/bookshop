package bookshop.dao.impl;

import bookshop.dao.InventoryDetailDao;
import bookshop.domain.Inventory;
import bookshop.domain.InventoryDetail;

import common.HibernateUtil;

public class InventoryDetailDaoImpl implements InventoryDetailDao {
	
	@Override
	public void save(InventoryDetail inventoryDetail) {
		HibernateUtil.save(inventoryDetail);
	}

	@Override
	public void delete(InventoryDetail inventoryDetail) {
		HibernateUtil.delete(inventoryDetail);
	}
	
	@Override
	public void deleteById(Integer id){
		HibernateUtil.deleteById(InventoryDetail.class, id);
	}
	
	@Override
	public InventoryDetail findById(Integer id) {
		return (InventoryDetail) HibernateUtil.get(InventoryDetail.class, id);
	}

	@Override
	public void update(InventoryDetail inventoryDetail) {
		HibernateUtil.update(inventoryDetail);
	}
}
