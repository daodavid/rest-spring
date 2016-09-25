package com.library.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
 private int id;
 private String username;
 private String password;
 private Gender gender;
 private Town town;
 private List<Book> books;
 public User(String username, String password, Gender gender, Town town) {
	super();
	this.username = username;
	this.password = password;
	this.gender = gender;
	this.town = town;
}
public User(int id, String username, String password, Gender gender, Town town) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.gender = gender;
	this.town = town;
}
public User() {
	super();
}
@XmlElement
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@XmlElement
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@XmlElement
public Gender getGender() {
	return gender;
}
public void setGender(Gender gender) {
	this.gender = gender;
}
public List<Book> getBooks() {
	return books;
}
public void setBooks(List<Book> books) {
	this.books = books;
}
@XmlElement
public Town getTown() {
	return town;
}
public void setTown(Town town) {
	this.town = town;
}
}
