package bookshop.dao;

import bookshop.domain.OrderDetail;

public interface OrderDetailDao {

	public abstract void save(OrderDetail orderDetail);

	public abstract void delete(OrderDetail orderDetail);

	public abstract void deleteById(Integer id);
	
	public abstract OrderDetail findById(Integer id);

	public abstract void update(OrderDetail orderDetail);

}