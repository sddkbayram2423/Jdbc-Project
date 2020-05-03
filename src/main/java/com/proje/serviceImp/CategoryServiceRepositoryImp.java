package com.proje.serviceImp;

import java.util.List;


import com.proje.model.Category;
import com.proje.repository.CategoryRepository;
import com.proje.repositoryImp.CategoryRepositoryImp;
import com.proje.service.CategoryServiceRepository;

public class CategoryServiceRepositoryImp implements CategoryServiceRepository {
	private CategoryRepository categoryRepository=new CategoryRepositoryImp();

	@Override
	public void createCategoryTable() {
		this.categoryRepository.createCategoryTable();
		
	}

	@Override
	public void saveCategory(Category category) {
		this.categoryRepository.saveCategory(category);
		
	}

	@Override
	public Category findCategoryById(int id) {
		
		return this.categoryRepository.findCategoryById(id);
	}

	@Override
	public List<Category> listCategories() {
		
		return this.categoryRepository.listCategories();
	}

}
