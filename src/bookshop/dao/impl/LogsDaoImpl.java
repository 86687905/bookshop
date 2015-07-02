package bookshop.dao.impl;

import bookshop.dao.LogsDao;
import bookshop.domain.InventoryDetail;
import bookshop.domain.Logs;

import common.HibernateUtil;

public class LogsDaoImpl implements LogsDao {

	@Override
	public void save(Logs logs) {
		HibernateUtil.save(logs);
	}

	@Override
	public void delete(Logs logs) {
		HibernateUtil.delete(logs);
	}
	
	@Override
	public void deleteById(Integer id){
		HibernateUtil.deleteById(Logs.class, id);
	}
	
	@Override
	public Logs findById(Integer id) {
		return (Logs) HibernateUtil.get(Logs.class, id);
	}

	@Override
	public void update(Logs logs) {
		HibernateUtil.update(logs);
	}

}
