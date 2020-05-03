package com.proje.model;

import java.util.Date;

public class Product {
		
	
	 private int productID;
	 private String productName;
	 private double unitPrice;
	 private int avaible;
	 private Date addDate;
	 private Date updateDate;
	 private Category category ;
	 private Brand brand;
	 
	 public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int productID, String productName, double unitPrice, int avaible, Date addDate, Date updateDate,
			Category category, Brand brand) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.avaible = avaible;
		this.addDate = addDate;
		this.updateDate = updateDate;
		this.category = category;
		this.brand = brand;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getAvaible() {
		return avaible;
	}

	public void setAvaible(int avaible) {
		this.avaible = avaible;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "productID: " + productID + "\tproductName: " + productName + "\t unitPrice: " + unitPrice
				+ "\t avaible:" + avaible + "\t addDate:" + addDate + "\t updateDate: " + updateDate + "\t category: "
				+ category + "\t brand: " + brand;
	}

	
	

}
