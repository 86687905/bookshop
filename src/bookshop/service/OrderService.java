package bookshop.service;

import java.util.List;

import bookshop.domain.Order;

public interface OrderService {

	public abstract void createOrder(Integer userId);

	public abstract void deleteOrder(Integer id);

	public abstract void checkoutOrder(Integer id);
	
	public abstract void addBook(Integer orderId, Integer bookId, Integer count);
	
	public abstract void setBookCount(Integer orderDetailId, Integer count);
	
	public abstract void removeBook(Integer orderId, Integer orderDetailId);
	
	public abstract List<Order> getOrderByUser(Integer id);

	public abstract List<Order> getAllOrder();

	public abstract List<Order> getOrderByPage(int offset, int size, Integer[] total);

	public abstract void createOrder(Order order);

	

	

}