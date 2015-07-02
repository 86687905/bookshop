package bookshop.dao;

import java.util.List;
import java.util.Set;

import bookshop.domain.Order;
import bookshop.domain.OrderDetail;

public interface OrderDao {

	public abstract void save(Order order);

	public abstract void delete(Order order);

	public abstract void deleteById(Integer id);
	
	public abstract Order findById(Integer id);

	public abstract void update(Order order);

	public abstract Set<OrderDetail> getDetails(Integer id);

	public abstract List<Order> findByUser(Integer id);

	public abstract List<Order> findAll();

	public abstract List<Order> findByPage(int offset, int size, Integer[] total);
	
	public abstract void addBook(Integer orderId, Integer bookId, Integer count);

	public abstract void removeBook(Integer orderId, Integer orderDetailId);

	

}