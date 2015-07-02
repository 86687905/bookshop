package bookshop.dao.factory;

import bookshop.dao.BookDao;
import bookshop.dao.InventoryDao;
import bookshop.dao.InventoryDetailDao;
import bookshop.dao.LogsDao;
import bookshop.dao.OrderDao;
import bookshop.dao.OrderDetailDao;
import bookshop.dao.UserDao;
import bookshop.dao.impl.BookDaoImpl;
import bookshop.dao.impl.InventoryDaoImpl;
import bookshop.dao.impl.InventoryDetailDaoImpl;
import bookshop.dao.impl.LogsDaoImpl;
import bookshop.dao.impl.OrderDaoImpl;
import bookshop.dao.impl.OrderDetailDaoImpl;
import bookshop.dao.impl.UserDaoImpl;

public class DaoFactory {
	private BookDao bookDao = new BookDaoImpl();
	private InventoryDao inventoryDao = new InventoryDaoImpl();
	private InventoryDetailDao inventoryDetailDao = new InventoryDetailDaoImpl();
	private LogsDao logsDao = new LogsDaoImpl();
	private OrderDao orderDao = new OrderDaoImpl();
	private OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();
	private UserDao userDao = new UserDaoImpl();

	private static DaoFactory instance = null;

	private DaoFactory() {

	}

	public static DaoFactory getInstance() {
		if (instance == null) {
			instance = new DaoFactory();
		}
		return instance;
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public InventoryDao getInventoryDao() {
		return inventoryDao;
	}

	public InventoryDetailDao getInventoryDetailDao() {
		return inventoryDetailDao;
	}

	public LogsDao getLogsDao() {
		return logsDao;
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public OrderDetailDao getOrderDetailDao() {
		return orderDetailDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}
}
