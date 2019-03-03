package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.FlightService;
import com.service.Imp.FlightServiceImp;

public class FlightDeleteAction extends HttpServlet {

	@Override
	protected void service(HttpServletRequest hsr, HttpServletResponse hsrr)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(hsr.getParameter("id"));
		FlightService fs = new FlightServiceImp();
		fs.delete(id);
		hsrr.sendRedirect("/user-flight/private/showall");
		
	}
}
