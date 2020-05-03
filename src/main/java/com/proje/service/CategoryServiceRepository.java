package com.proje.service;

import java.util.List;

import com.proje.model.Category;

public interface CategoryServiceRepository {
	
	public void createCategoryTable();
	
	public void saveCategory(Category category);
	
	public Category findCategoryById(int id);
	
	public List<Category> listCategories();


}
