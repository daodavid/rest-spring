package com.library.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookList {
  private List<Book> books;
@XmlElement
public List<Book> getBooks() {
	return books;
}

public BookList(List<Book> books) {
	super();
	this.books = books;
}

public void setBooks(List<Book> books) {
	this.books = books;
}

public BookList() {
	super();
}
}
