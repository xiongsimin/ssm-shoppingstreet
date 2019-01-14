package com.ssm.shoppingstreet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssm.shoppingstreet.modal.ShoppingCart;
import com.ssm.shoppingstreet.modal.User;
import com.ssm.shoppingstreet.service.ShoppingCartService;
import com.ssm.shoppingstreet.service.UserService;

@Controller
public class LoginAndRegisterController {
	@Autowired
	private UserService userService;
	@Autowired
	private ShoppingCartService shoppingCartService;

	@GetMapping("/goLogin")
	public String goLogin(HttpServletRequest request, ModelMap map) {
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
			map.addAttribute("userName", userName);
			map.addAttribute("password", password);
		} else {
			map.addAttribute("userName", "");
			map.addAttribute("password", "");
		}
		return "Login";
	}

	@PostMapping("/login")
	public String login(String name, String password, String rememberPassword, ModelMap map,
			HttpServletResponse response, HttpServletRequest request) throws IOException {

		User user = userService.findUserByName(name);
		if (user == null) {
			map.addAttribute("msg", "�û���" + name + "�������ڣ�");
			return "Login";
		}
		if (!user.getPassword().equals(password)) {
			map.addAttribute("msg", "�û��������벻ƥ�䣡");
			return "Login";
		}
		// ����cookie
		if (rememberPassword != null && !rememberPassword.equals("")) {// ��ס�û���Ϣ
			Cookie cookie1 = new Cookie("userName", user.getName());
			Cookie cookie2 = new Cookie("password", user.getPassword());
			cookie1.setMaxAge(5 * 60);
			cookie2.setMaxAge(5 * 60);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
		} else {// ����ס�û���Ϣ��ʹcookieʧЧ��
			Cookie cookie1 = new Cookie("userName", "");
			Cookie cookie2 = new Cookie("password", "");
			cookie1.setMaxAge(0);
			cookie2.setMaxAge(0);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
		}
		// ����session����¼��Ϣ�Լ����ﳵ��Ϣ��
		HttpSession session = request.getSession();
		session.setAttribute("userId", user.getId());
		session.setAttribute("userName", user.getName());
		session.setAttribute("password", user.getPassword());
		List<ShoppingCart> shoppingCartList = shoppingCartService.findShoppingCartByUserId(user.getId());
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
		response.sendRedirect("/shoppingstreet/goIndex");
		return "Index";
	}

	@GetMapping("/logout")
	public void logout(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();
		session.invalidate();
		try {
			response.sendRedirect("/shoppingstreet/goLogin");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GetMapping("/goRegist")
	public String goRegist() {
		return "Regist";
	}

	@PostMapping("/regist")
	public String regist(String name, String password, String rePassword, String email, String phone,
			String inviterName, int inviterId, ModelMap map) {
		User user = userService.findUserByName(name);
		if (user != null) {
			map.addAttribute("msg", "ע��ʧ�ܣ��û�����" + name + "���Ѵ��ڣ�");
			return "Regist";
		}
		userService.addUser(name, password, rePassword, email, phone, inviterName, inviterId);
		map.addAttribute("msg", "ע��ɹ��������û����ǡ�" + name + "�����뷵�ص�¼ҳ��¼��");
		return "Regist";
	}

	@GetMapping("/goIndex")
	public String goIndex() {
		return "Index";
	}
}
