package com.proje.repository;

import java.util.List;

import com.proje.model.Category;

public interface CategoryRepository {
	
	public void createCategoryTable();
	
	public void saveCategory(Category category);
	
	public Category findCategoryById(int id);
	
	public List<Category> listCategories();



}
