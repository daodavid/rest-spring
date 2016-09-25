package com.service.xml;

import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;

import javax.ejb.Singleton;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.library.entity.Book;
import com.library.entity.BookList;
import com.library.entity.User;



@Singleton
public class JaxB {

  private StringWriter m;

   public  String jaxbObjectToXML(User h) {
	    String xmlString = "";
	    try {
	        JAXBContext context = JAXBContext.newInstance(User.class);
	        Marshaller m = context.createMarshaller();

	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

	        StringWriter sw = new StringWriter();
	        m.marshal(h, sw);
	        xmlString = sw.toString();

	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }

	    return xmlString;
	}
   public  String jaxbObjectToXML(List<Book> books) {
	    String xmlString = "";
	    try {
	        JAXBContext context = JAXBContext.newInstance(BookList.class);
	        Marshaller m = context.createMarshaller();

	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

	        StringWriter sw = new StringWriter();
	        m.marshal(new BookList(books), sw);
	        xmlString = sw.toString();
	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }

	    return xmlString;
	}
   public  User getXml(InputStream i) {
	   try {
		JAXBContext context = JAXBContext.newInstance(User.class);
		User st = JAXB.unmarshal(i, User.class);
		return st;
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	   
   }
   public  Book getXmlBook(InputStream i) {
	   try {
		JAXBContext context = JAXBContext.newInstance(Book.class);
		Book st = JAXB.unmarshal(i,Book.class);
		return st;
	} catch (JAXBException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	   
   }
   public  String jaxbObjectToXML(Book book) {
	    String xmlString = "";
	    try {
	        JAXBContext context = JAXBContext.newInstance(Book.class);
	        Marshaller m = context.createMarshaller();

	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

	        StringWriter sw = new StringWriter();
	        m.marshal(book, sw);
	        xmlString = sw.toString();
	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }

	    return xmlString;
	}

}

