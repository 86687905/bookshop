package bookshop.service.impl;

import bookshop.dao.BookDao;
import bookshop.dao.InventoryDao;
import bookshop.dao.InventoryDetailDao;
import bookshop.dao.LogsDao;
import bookshop.dao.OrderDao;
import bookshop.dao.OrderDetailDao;
import bookshop.dao.UserDao;
import bookshop.dao.factory.DaoFactory;

public class BaseService {
	protected BookDao bookDao = DaoFactory.getInstance().getBookDao();
	protected InventoryDao inventoryDao = DaoFactory.getInstance().getInventoryDao();
	protected InventoryDetailDao inventoryDetailDao = DaoFactory.getInstance().getInventoryDetailDao();
	protected LogsDao logsDao = DaoFactory.getInstance().getLogsDao();
	protected OrderDao orderDao = DaoFactory.getInstance().getOrderDao();
	protected OrderDetailDao orderDetailDao = DaoFactory.getInstance().getOrderDetailDao();
	protected UserDao userDao = DaoFactory.getInstance().getUserDao(); 
}
