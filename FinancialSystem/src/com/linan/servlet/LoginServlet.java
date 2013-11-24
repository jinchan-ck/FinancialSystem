package com.linan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linan.service.UserService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		username = request.getParameter("username");
		password = request.getParameter("password");
		String message = validateStudent();
		response.getWriter().write(message);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	public String validateStudent() {
		UserService studentService = new UserService();
		String result = "";
		int state = studentService.validate(username, password);
		switch (state) {
		case UserService.LOGIN_SUCCESS:
			result = "��֤�ɹ�";
			break;
		case UserService.PASSWORD_ERROR:
			result = "�������";
			break;
		case UserService.STUDENT_NOT_EXIT:
			result = "�û���������";
			break;
		default:
			result = "δ֪���󣡣�";
			break;
		}
		return result;
	}

}
