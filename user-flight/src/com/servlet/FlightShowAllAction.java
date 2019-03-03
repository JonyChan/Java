package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import com.entity.flight;
import com.service.FlightService;
import com.service.Imp.FlightServiceImp;

public class FlightShowAllAction extends HttpServlet {

	@Override
	public void service(ServletRequest hsr, ServletResponse hsrr)
			throws ServletException, IOException {
		FlightService fs = new FlightServiceImp();
		List<flight> list = fs.selectAll();
		hsr.setAttribute("abc", list);
		hsr.getRequestDispatcher("/jsp/private/showAll.jsp").forward(hsr, hsrr);
	
		
	}
}
