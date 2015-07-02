package bookshop.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bookshop.dao.OrderDao;
import bookshop.domain.Book;
import bookshop.domain.Order;
import bookshop.domain.OrderDetail;

import common.HibernateUtil;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void save(Order order) {
		HibernateUtil.save(order);
	}

	@Override
	public void delete(Order order) {
		HibernateUtil.delete(order);
	}
	
	@Override
	public void deleteById(Integer id){
		HibernateUtil.deleteById(Order.class, id);
	}
	
	@Override
	public Order findById(Integer id) {
		return (Order) HibernateUtil.get(Order.class, id);
	}

	@Override
	public void update(Order order) {
		HibernateUtil.update(order);
	}

	@Override
	public Set<OrderDetail> getDetails(Integer id) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		
		Order order = (Order) session.get(Order.class, id);
		order.getOrderDetails().size();
		Set<OrderDetail> ods = order.getOrderDetails();
		
		transaction.commit();
		HibernateUtil.closeSession();
		return ods;
	}

	private List<Order> findByProperty(String property, Object value) {
		String hql = "from Order as model where model." + property + "= ?";
		return (List<Order>) HibernateUtil.find(hql, value);
	}
	
	@Override
	public List<Order> findByUser(Integer id) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		
		String hql = "from Order as model where model.user.id = " + id;
		List<Order> list = (List<Order>)session.createQuery(hql).list();
		transaction.commit();
		HibernateUtil.closeSession();
		return list;
	}
	
	@Override
	public List<Order> findAll() {
		String hql = "from Order";
		return (List<Order>) HibernateUtil.find(hql);
	}

	@Override
	public List<Order> findByPage(int offset, int size, Integer[] total) {
		String hql = "from Order";
		return (List<Order>) HibernateUtil.findByPage(hql, offset, size, total);
	}

	@Override
	public void removeBook(Integer orderId, Integer orderDetailId) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		
		Object o = session.get(OrderDetail.class, orderDetailId);
		session.delete(o);
		
		Order order = (Order) session.get(Order.class, orderId);
		if(order.getOrderDetails().size() == 1) {
			session.delete(order);
		}else{
			session.update(order);
		}
		
		transaction.commit();
		HibernateUtil.closeSession();
	}

	@Override
	public void addBook(Integer orderId, Integer bookId, Integer count) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		
		Order order = (Order)session.get(Order.class, orderId);
		Book book = (Book) session.get(Book.class, bookId);
		
		OrderDetail detail = new OrderDetail();
		detail.setBook(book);
		detail.setCount(count);
		detail.setOrder(order);
		session.save(detail);
		
		order.getOrderDetails().add(detail);
		order.setTotalPrice(order.getTotalPrice() + book.getPrice() * count);
		session.update(order);
		
		transaction.commit();
		HibernateUtil.closeSession();
		
	}
}
