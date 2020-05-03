package com.proje.repository;

import java.util.List;

import com.proje.model.Brand;

public interface BrandRepository {
	
	public void createBrandTable();
	
	public void saveBrand(Brand brand);
	
	public Brand findBrandById(int id);
	
	public List<Brand> listBrands();
	
	

}
