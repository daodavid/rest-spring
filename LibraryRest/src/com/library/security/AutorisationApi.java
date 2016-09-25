package com.library.security;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.entity.User;
import com.repositoryMySql.dao.Dao;
import com.service.xml.JaxB;

@WebServlet("/AutorisationApi")
public class AutorisationApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	JaxB xmlService;
	@EJB
	Dao dao;

	public AutorisationApi() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter p = response.getWriter();
		System.out.println(request.getSession().getAttribute("username"));
		//check weather have username and comapare the pass,if that is true,is create the session object with this username
		if (request.getSession().getAttribute("username") != null) {
			p.write("ok");
		} else {
			p.write("failed");
		}
		;

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream i = request.getInputStream();
		response.setContentType("application/xml");
		PrintWriter p = response.getWriter();
		StringWriter st = new StringWriter();
		System.out.println("autoriazation..............");
		User u = xmlService.getXml(i);
		if (dao.get(u.getUsername()).getPassword().equals(u.getPassword())) {
			request.getSession().setAttribute("username", u.getUsername());
			

		} else {
			p.append("wrong");
		}
		p.append("<evala>evala<evala>");
	}

}
