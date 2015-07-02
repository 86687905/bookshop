package bookshop.dao.impl;

import bookshop.dao.OrderDetailDao;
import bookshop.domain.Order;
import bookshop.domain.OrderDetail;

import common.HibernateUtil;

public class OrderDetailDaoImpl implements OrderDetailDao{

	@Override
	public void save(OrderDetail orderDetail) {
		HibernateUtil.save(orderDetail);
	}

	@Override
	public void delete(OrderDetail orderDetail) {
		HibernateUtil.delete(orderDetail);
	}
	
	@Override
	public void deleteById(Integer id){
		HibernateUtil.deleteById(OrderDetail.class, id);
	}
	
	@Override
	public OrderDetail findById(Integer id) {
		return (OrderDetail) HibernateUtil.get(OrderDetail.class, id);
	}

	@Override
	public void update(OrderDetail orderDetail) {
		HibernateUtil.update(orderDetail);
	}
}
