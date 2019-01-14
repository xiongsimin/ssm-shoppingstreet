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
		// 执行完毕，返回前拦截
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// 在处理过程中，执行拦截
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// 在拦截点执行前拦截，如果返回true则不执行拦截点后的操作（拦截成功）
		// 返回false则不执行拦截
		HttpSession session = request.getSession();
//		System.out.println(request.getRequestURI());
		// String uri = request.getRequestURI(); // 获取登录的uri，这个是不进行拦截的
		// if(session.getAttribute("LOGIN_USER")!=null ||
		// uri.indexOf("system/login")!=-1) {// 说明登录成功 或者 执行登录功能
		if (session.getAttribute("userId") != null) {
			// 登录成功不拦截
			return true;
		} else {
			// 判断是否是登录页和注册页
			if (request.getRequestURI().equals("/shoppingstreet/goLogin")||request.getRequestURI().equals("/shoppingstreet/goRegist")||request.getRequestURI().equals("/shoppingstreet/login")||request.getRequestURI().equals("/shoppingstreet/regist")) {
				return true;
			} else {

				// 判断是否有cookie
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
					if (user == null) {// 用户不存在，直接放行，不自动登录
						return true;
					} else {// 自动登录，并设置cookie和session
						// 更新cookie
						Cookie cookie1 = new Cookie("userName", user.getName());
						Cookie cookie2 = new Cookie("password", user.getPassword());
						cookie1.setMaxAge(5 * 60);
						cookie2.setMaxAge(5 * 60);
						response.addCookie(cookie1);
						response.addCookie(cookie2);
						// 设置session（登录信息以及购物车信息）
						session.setAttribute("userId", user.getId());
						session.setAttribute("userName", user.getName());
						session.setAttribute("password", user.getPassword());
						List<ShoppingCart> shoppingCartList = shoppingCartService
								.findShoppingCartByUserId(user.getId());
						// System.out.println(shoppingCartList);
						int sumPrice = 0;// 计算总价
						int sumBonusPoints = 0;// 计算积分
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
