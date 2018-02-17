package com.crmsys.web.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.crmsys.domain.User;
import com.crmsys.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3713577231876403452L;

	private User user = new User();
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	public String regist() {
		System.out.println("web层被访问···");
		System.out.println("访问的用户为：" + user.getUser_name());
		String username = user.getUser_name();
		String password = user.getUser_password();
		if(username != null && username.trim() != "") {
			if(password != null && password.trim() != "") {
				userService.add(user);
				return "login";
			}
		}
		return "error";
	}

	public String checkUsername() {
		user.setUser_name(user.getUser_name().trim());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");

			User findUser = userService.checkUsername(user);
			try {
				PrintWriter writer = response.getWriter();
				if(findUser != null) {
					writer.print("no");
				}else {
					writer.print("yes");
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		return NONE;
	}
	
	public String login() {
		String username = user.getUser_name();
		String password = user.getUser_password();
		if(username != null && username.trim() != "") {
			if(password != null && password.trim() != "") {
				User findUser = userService.login(user);
				HttpServletRequest request = ServletActionContext.getRequest();
				HttpSession session = request.getSession();
				session.setAttribute("user", findUser);
				return "index";
			}
		}
		return "login";
	}
}
