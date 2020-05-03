package com.proje.queries;

public class BrandQueries {
	public static final String createTableBrandQuery="create table brand(brandID int primary key not null,brandName varchar(20))";
	public static final String findBrandByIdQery="SELECT* FROM brand WHERE brandID=?";
	public static final String listBrandsQery="SELECT* FROM brand";
	public static final String saveBrandQery="insert into brand(brandID,brandName) VALUES(?,?)";

}
