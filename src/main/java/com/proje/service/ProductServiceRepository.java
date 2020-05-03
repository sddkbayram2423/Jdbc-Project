package com.proje.service;

import java.util.List;

import com.proje.model.Product;

public interface ProductServiceRepository {
	
	public void createProductTable();
	
	public void saveProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteUserProduct(int productId);
	
	public void deleteProductById(int productId);
	
	public Product findProductById(int productId);
	
	public List<Product> findProducts();

}
