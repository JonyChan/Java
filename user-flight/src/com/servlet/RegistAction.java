package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Users;
import com.service.UserService;
import com.service.Imp.UserServiceImp;

public class RegistAction extends HttpServlet {

	@Override
	protected void service(HttpServletRequest hsr, HttpServletResponse hsrr)
			throws ServletException, IOException {
		
		String name = hsr.getParameter("abc");
		String password = hsr.getParameter("xyz");
		
		UserService us = new UserServiceImp();
		us.regist(new Users(name,password));
		
		hsr.getRequestDispatcher("/login.jsp").forward(hsr, hsrr);
		
		
	}
}
