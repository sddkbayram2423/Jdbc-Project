package com.proje.queries;



public class ProductQueries {
	
	public static final String createTableQuery=
			"create table Product(productID int primary key not null,productName varchar(20),"
			+ "unitPrice double,avaible int,addDate TIMESTAMP, updateDate TIMESTAMP,categoryID int,brandID int,"
			+ "foreign key (categoryId) references category(categoryId), foreign key (brandID) references brand(brandID))";
	
	public static final String saveProductQery="insert into Product(productID,productName,unitPrice,avaible,addDate,updateDate,categoryId,brandID) values(?,?,?,?,?,?,?,?)";
	
	public static final String updateProductQery="update product set productName=?,avaible=?,unitPrice=?,updateDate=?,categoryID=?,brandID=? where productID=?";
	
	public static final String deleteUser_ProductQery="delete from user_product where productID=?";
	
	public static final String deleteProductByIdQery="delete from product where productID=? ";
	
	public static final String findProductByIdQery="select *from product p left join category c on(p.categoryID=c.categoryID) left join brand b on(b.brandId=p.brandID) where productID=?";
	
	public static final String findProductsQery="Select* from product p LEFT JOIN category c on(p.categoryID=c.categoryID) left join brand b on(p.brandID=b.brandID)";
	
	
	

}

