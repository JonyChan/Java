package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.UserService;
import com.service.Imp.UserServiceImp;

public class LoginAction extends HttpServlet {

	@Override
	protected void service(HttpServletRequest hsr, HttpServletResponse hsrr)
			throws ServletException, IOException {
		
		String name = hsr.getParameter("abc");
		String password = hsr.getParameter("xyz");
	
		UserService us = new UserServiceImp();
		boolean loginSuccess = us.login(name, password);
		//System.out.println("----ok");
		if(loginSuccess){
			HttpSession session = hsr.getSession();
			session.setAttribute("abc", name);
			hsr.getRequestDispatcher("/jsp/LoginSuccess.jsp").forward(hsr, hsrr);
			//System.out.println("--------ojuh");
		}else{
			hsr.getRequestDispatcher("/jsp/error.jsp").forward(hsr, hsrr);
			
		}
		
	
	}
}
