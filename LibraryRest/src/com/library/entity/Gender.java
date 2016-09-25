package com.library.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Gender {
  private int id;
  public Gender() {
	super();
}
public Gender(String name) {
	super();
	this.name = name;
}
private String name;
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
