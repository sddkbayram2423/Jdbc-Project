package com.proje.service;

import java.util.List;

import com.proje.model.Brand;

public interface BrandServiceRepository {
	
	public void createBrandTable();
	
	public void saveBrand(Brand brand);
	
	public Brand findBrandById(int id);
	
	public List<Brand> listBrands();

}
