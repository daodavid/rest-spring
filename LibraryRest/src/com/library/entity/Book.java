package com.library.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {
  private int id;
  private String name;
public Book() {
	super();
}
public Book(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
@XmlElement
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@XmlElement
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
