package bookshop.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import bookshop.domain.Inventory;
import bookshop.domain.InventoryDetail;
import bookshop.domain.Order;
import bookshop.domain.OrderDetail;
import bookshop.service.OrderService;

public class OrderServiceImpl extends BaseService implements OrderService {
	
	@Override
	public void createOrder(Order order) {
		orderDao.save(order);
	}
	@Override
	public void createOrder(Integer userId) {
		Inventory inventory = inventoryDao.getByUser(userId);

		Order order = new Order();
		order.setOrderDate(new Date());
		order.setUser(userDao.findById(userId));
		order.setTotalPrice(0.0);
		orderDao.save(order);

		Double totalPrice = 0.0;
		for (InventoryDetail inventoryDetail : inventory.getInventoryDetails()) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrder(order);
			orderDetail.setBook(inventoryDetail.getBook());
			orderDetail.setCount(inventoryDetail.getCount());
			totalPrice += orderDetail.getBook().getPrice() * orderDetail.getCount();
			orderDetailDao.save(orderDetail);
			inventoryDetailDao.delete(inventoryDetail);
			order.getOrderDetails().add(orderDetail);
		}
		order.setTotalPrice(totalPrice);
		orderDao.update(order);
		inventoryDao.deleteByUser(userId);
	}

	@Override
	public void deleteOrder(Integer id) {
		Set<OrderDetail> set = orderDao.getDetails(id);
		for (OrderDetail orderDetail : set) {
			orderDetailDao.delete(orderDetail);
		}
		orderDao.deleteById(id);
	}

	@Override
	public void checkoutOrder(Integer id) {
		Order order = orderDao.findById(id);
		order.setCheckoutDate(new Date());
		orderDao.update(order);
	}
	@Override
	public void addBook(Integer orderId, Integer bookId, Integer count) {
		orderDao.addBook(orderId, bookId, count);	
	}
	@Override
	public void setBookCount(Integer orderDetailId, Integer count) {
		OrderDetail orderDetail = orderDetailDao.findById(orderDetailId);
		orderDetail.setCount(count < 0 ? 0 : count);
		orderDetailDao.update(orderDetail);
	}
	@Override
	public void removeBook(Integer orderId, Integer orderDetailId) {
		orderDao.removeBook(orderId, orderDetailId);
	}
	@Override
	public List<Order> getOrderByUser(Integer id) {
		return orderDao.findByUser(id);
	}

	@Override
	public List<Order> getAllOrder() {
		return orderDao.findAll();
	}

	@Override
	public List<Order> getOrderByPage(int offset, int size, Integer[] total) {
		return orderDao.findByPage(offset, size, total);
	}
}
