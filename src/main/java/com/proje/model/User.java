package com.proje.model;

import java.util.List;

public class User {
	
	private int id;
	private String name;
	private String lastname;
	private String city;
	private String country;
	private List<Product> products;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String lastname, String city, String country) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.city = city;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return  id + "\t" + name + "\t" + lastname + "\t" + city + "\t"+ country+"\t"+products;
	}
	

}
