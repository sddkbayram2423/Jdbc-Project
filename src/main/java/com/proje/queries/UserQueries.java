package com.proje.queries;

public class UserQueries {
	

	public static final String createTableUserQuery="create table user(userId int primary key not null,name varchar(25),lastname varchar(25),city varchar(25),"
			+ "country varchar(25),productID int, foreign key (productID) references product(productID))";
	
	
	public static final String createTableUser_ProductQuery="create table user_product(userId int primary key not null,productID int, "
			+  	"foreign key (productID) references product(productID))";
	
	public static final String saveUser_ProductQery="insert into user_product(userId,productID) values(?,?)";
	
	public static final String saveUserQuery="insert into user(userId,name,lastname,city,country) values(?,?,?,?,?)";
	
	public static final String deleteUser_ProductQuery="delete from user_product where userId=?";
	
	public static final String updateUserQuery="update User set name=?,lastname=?,city=?,country=? where userId=? ";
	
	public static final String deleteUserQuery="delete from user where userId=? ";
	

	public static final String findUserByIdQuery="select *from user where userId=? ";
	
	public static final String listUsersQuery="select *from user";
	
	public static final String findUserByNameQuery=" select *from user where name=?";
	
	public static final String findUser_ProductByIdQery="select *from user u left outer join user_product up on(u.userId=up.userId)"
			+ "left join product p on(p.productId=up.productId) "
			+ "left join category c on(p.categoryId=c.categoryId) "
			+ "left join brand b on(p.brandId=b.brandId) where userId=?";
	
	


}
