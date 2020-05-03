package com.proje.queries;

public class CategoryQueries {
	
	public static final String findCategoryByIdQery="SELECT* FROM category WHERE categoryID=?";
	public static final String listCategoriesQery="SELECT* FROM category";
	public static final String saveCategoryQuery="insert into category(categoryID,categoryName) VALUES(?,?)";
	public static final String createTableCategoryQuery="create table category(categoryID int primary key not null, categoryName varchar(20))";
}
