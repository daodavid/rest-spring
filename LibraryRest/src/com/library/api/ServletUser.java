package com.library.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.entity.Gender;
import com.library.entity.Town;
import com.library.entity.User;
import com.repositoryMySql.dao.Dao;
import com.service.xml.JaxB;

/**
 * Servlet implementation class ServletUser
 */
@WebServlet("/ServletUser")
public class ServletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletUser() {
		super();

	}

	// enterprice java beans
	@EJB
	JaxB xmlService;
	@EJB
	Dao dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/xml");
		User u = dao.get((String)request.getSession().getAttribute("username"));
	   //	System.out.println("jjjj" + u.getUsername() + u.getGender().getName() + u.getTown().getName());
		//get object from mysql and convert to xml,after that  xml get responce with this object
		String v = xmlService.jaxbObjectToXML(u);
		response.getWriter().append(v);
	}

	//get xml from register page convert to xml,and send mysql
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream i = request.getInputStream();
		response.setContentType("application/xml");
		PrintWriter p = response.getWriter();
		StringWriter st = new StringWriter();
		User u = xmlService.getXml(i);
		dao.insert(u);
		int c;
		// while((c=i.read())!=-1){
		// st.append((char)c);
		// }
		// System.out.println(st.toString());

		//System.out.println("P<>" + u.getUsername() + u.getGender().getName() + " " + u.getTown().getName()
				//+ u.getPassword() + " " + u.getUsername());

		// doGet(request, response);
	}

}
