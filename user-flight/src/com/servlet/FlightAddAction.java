package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.flight;
import com.service.FlightService;
import com.service.Imp.FlightServiceImp;

public class FlightAddAction extends HttpServlet {

	@Override
	protected void service(HttpServletRequest hsr, HttpServletResponse hsrr)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(hsr.getParameter("id"));
		String launch = hsr.getParameter("lau");
		String land = hsr.getParameter("lan");
		String name = hsr.getParameter("name");
		String length = hsr.getParameter("len");
		int price = Integer.parseInt(hsr.getParameter("price"));
		flight f = new flight(id,launch,land,name,length,price);
		FlightService fs = new FlightServiceImp();
		fs.insert(f);
		hsrr.sendRedirect("/user-flight/private/showall");
		
	}
}
