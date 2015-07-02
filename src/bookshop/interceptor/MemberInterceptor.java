package bookshop.interceptor;

import java.util.Map;

import bookshop.constant.CONSTANT;
import bookshop.domain.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MemberInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		User user = (User)session.get(CONSTANT.USER);
		if (user != null && user.getRole() == 1){
			return invocation.invoke();
		}
		return Action.LOGIN;		
	}

}
