package com.proje.serviceImp;

import java.util.List;

import com.proje.model.Brand;
import com.proje.repository.BrandRepository;
import com.proje.repositoryImp.BrandRepositoryImp;
import com.proje.service.BrandServiceRepository;

public class BrandServiceRepositoryImp implements BrandServiceRepository{
	private BrandRepository brandRepository=new BrandRepositoryImp();
	@Override
	public void createBrandTable() {
		this.brandRepository.createBrandTable();
		
	}

	@Override
	public void saveBrand(Brand brand) {
	this.brandRepository.saveBrand(brand);
		
	}

	@Override
	public Brand findBrandById(int id) {
		
		return this.brandRepository.findBrandById(id);
	}

	@Override
	public List<Brand> listBrands() {
		
		return this.brandRepository.listBrands();
	}

}
