package bookshop.action;

import bookshop.service.BookService;
import bookshop.service.InventoryService;
import bookshop.service.OrderService;
import bookshop.service.UserService;
import bookshop.service.factory.ServiceFactory;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	protected BookService bookService = ServiceFactory.getInstance().getBookService();
	protected InventoryService inventoryService = ServiceFactory.getInstance().getInventoryService();
	protected OrderService orderService = ServiceFactory.getInstance().getOrderService();
	protected UserService userService = ServiceFactory.getInstance().getUserService();
}
