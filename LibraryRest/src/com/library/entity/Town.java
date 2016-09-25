package com.library.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Town {

	private int id;

	public Town(String name) {
		super();
		this.name = name;
	}
	public Town() {
		super();
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
