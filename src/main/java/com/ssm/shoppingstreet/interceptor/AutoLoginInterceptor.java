package com.ssm.shoppingstreet.interceptor;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.shoppingstreet.modal.ShoppingCart;
import com.ssm.shoppingstreet.modal.User;
import com.ssm.shoppingstreet.service.ShoppingCartService;
import com.ssm.shoppingstreet.service.UserService;

public class AutoLoginInterceptor implements HandlerInterceptor {
	@Autowired
	private UserService userService;
	@Autowired
	private ShoppingCartService shoppingCartService;

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// ִ����ϣ�����ǰ����
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// �ڴ�������У�ִ������
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// �����ص�ִ��ǰ���أ��������true��ִ�����ص��Ĳ��������سɹ���
		// ����false��ִ������
		HttpSession session = request.getSession();
//		System.out.println(request.getRequestURI());
		// String uri = request.getRequestURI(); // ��ȡ��¼��uri������ǲ��������ص�
		// if(session.getAttribute("LOGIN_USER")!=null ||
		// uri.indexOf("system/login")!=-1) {// ˵����¼�ɹ� ���� ִ�е�¼����
		if (session.getAttribute("userId") != null) {
			// ��¼�ɹ�������
			return true;
		} else {
			// �ж��Ƿ��ǵ�¼ҳ��ע��ҳ
			if (request.getRequestURI().equals("/shoppingstreet/goLogin")||request.getRequestURI().equals("/shoppingstreet/goRegist")||request.getRequestURI().equals("/shoppingstreet/login")||request.getRequestURI().equals("/shoppingstreet/regist")) {
				return true;
			} else {

				// �ж��Ƿ���cookie
				String userName = "";
				String password = "";
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (int i = 0; i < cookies.length; i++) {
						if (cookies[i].getName().equals("userName")) {
							userName = cookies[i].getValue();
							System.out.println(userName);
						}
						if (cookies[i].getName().equals("password")) {
							password = cookies[i].getValue();
							System.out.println(password);
						}
					}
				}
				if ((!userName.equals("")) && (!password.equals(""))) {
					User user = userService.findUserByName(userName);
					if (user == null) {// �û������ڣ�ֱ�ӷ��У����Զ���¼
						return true;
					} else {// �Զ���¼��������cookie��session
						// ����cookie
						Cookie cookie1 = new Cookie("userName", user.getName());
						Cookie cookie2 = new Cookie("password", user.getPassword());
						cookie1.setMaxAge(5 * 60);
						cookie2.setMaxAge(5 * 60);
						response.addCookie(cookie1);
						response.addCookie(cookie2);
						// ����session����¼��Ϣ�Լ����ﳵ��Ϣ��
						session.setAttribute("userId", user.getId());
						session.setAttribute("userName", user.getName());
						session.setAttribute("password", user.getPassword());
						List<ShoppingCart> shoppingCartList = shoppingCartService
								.findShoppingCartByUserId(user.getId());
						// System.out.println(shoppingCartList);
						int sumPrice = 0;// �����ܼ�
						int sumBonusPoints = 0;// �������
						for (ShoppingCart shoppingCart : shoppingCartList) {
							sumPrice += shoppingCart.getPrice() * shoppingCart.getNum();
							sumBonusPoints += shoppingCart.getBonusPoints() * shoppingCart.getNum();
						}
						session.setAttribute("shoppingCartList", shoppingCartList);
						session.setAttribute("sumPrice", sumPrice);
						session.setAttribute("sumBonusPoints", sumBonusPoints);
					}
				}
				return true;
			}
		}
	}
}
