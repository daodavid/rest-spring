package com.library.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.entity.Book;
import com.repositoryMySql.dao.Dao;
import com.service.xml.JaxB;

@WebServlet("/BookApi")
public class BookApi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookApi() {
		super();

	}

	@EJB
	JaxB xmlConverter;
	@EJB
	Dao daoBook;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/xml");

		String a = xmlConverter.jaxbObjectToXML(daoBook.getBooks());
		response.getWriter().append(a);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream i = request.getInputStream();
		Book b = new Book(1, "d");
		System.out.println(xmlConverter.jaxbObjectToXML(b));
		Book book = xmlConverter.getXmlBook(i);
		System.out.println(book.getName());
		daoBook.addBook(book.getName());

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InputStream i = request.getInputStream();

		Book book = xmlConverter.getXmlBook(i);
		System.out.println(book.getName());
		daoBook.addBookUser(book.getName(), (String) request.getSession().getAttribute("username"));

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
