package bookshop.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bookshop.dao.InventoryDao;
import bookshop.domain.Book;
import bookshop.domain.Inventory;
import bookshop.domain.InventoryDetail;
import bookshop.domain.User;

import common.HibernateUtil;

public class InventoryDaoImpl implements InventoryDao {

	@Override
	public void save(Inventory inventory) {
		HibernateUtil.save(inventory);
	}

	@Override
	public void delete(Inventory inventory) {
		HibernateUtil.delete(inventory);
	}

	@Override
	public void deleteByUser(Integer id) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		String hql = "delete Inventory as inventory where id.user = " + id;
		session.createQuery(hql).executeUpdate();
		transaction.commit();
		HibernateUtil.closeSession();
	}

	@Override
	public Inventory findById(Integer id) {
		return (Inventory) HibernateUtil.get(Inventory.class, id);
	}

	@Override
	public void update(Inventory inventory) {
		HibernateUtil.update(inventory);
	}

	@Override
	public void addBook(Integer userId, Integer bookId, Integer count) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();

		User user = (User) session.get(User.class, userId);
		Book book = (Book) session.get(Book.class, bookId);

		Inventory inventory = user.getInventory();
		if (inventory == null) {
			inventory = new Inventory();
			inventory.setCreateDate(new Date());
			inventory.setUser(user);
			inventory.setUpdateDate(new Date());
			session.save(inventory);
		}

		InventoryDetail inventoryDetail;
		
		String hql = "from InventoryDetail as id where id.inventory = " + inventory.getId() + " and id.book = " + book.getId();
		List<InventoryDetail> idl = (List<InventoryDetail>) session.createQuery(hql).list();
		if (idl.size() > 0) {
			inventoryDetail = idl.get(0);
			inventoryDetail.setCount(count + inventoryDetail.getCount());
			session.update(inventoryDetail);
		} else {
			inventoryDetail = new InventoryDetail();
			inventoryDetail.setBook(book);
			inventoryDetail.setCount(count);
			inventoryDetail.setInventory(inventory);
			session.save(inventoryDetail);
		}

		inventory.getInventoryDetails().add(inventoryDetail);
		inventory.setUpdateDate(new Date());
		session.update(inventory);

		transaction.commit();
		HibernateUtil.closeSession();
	}

	@Override
	public void removeBook(Integer inventoryId, Integer inventoryDetailId) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		
		Object o = session.get(InventoryDetail.class, inventoryDetailId);
		session.delete(o);
		
		Inventory inventory = (Inventory) session.get(Inventory.class, inventoryId);
		if(inventory.getInventoryDetails().size() == 1) {
			session.delete(inventory);
		}else{
			inventory.setUpdateDate(new Date());
			session.update(inventory);
		}
		
		transaction.commit();
		HibernateUtil.closeSession();
	}

	@Override
	public Inventory getByUser(Integer id) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		String hql = "from Inventory as inventory where inventory.user = " + id;
		List list = session.createQuery(hql).list();
		Inventory inventory;
		if(list.size()>0){
			inventory = (Inventory) list.get(0);
			inventory.getInventoryDetails().size();
		}else{
			inventory = null;
		}
		transaction.commit();
		HibernateUtil.closeSession();
		return inventory;
	}
}
