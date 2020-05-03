package com.proje.serviceImp;

import java.util.List;

import com.proje.model.Product;
import com.proje.repository.ProductRepository;
import com.proje.repositoryImp.ProductRepositoryImp;
import com.proje.service.ProductServiceRepository;

public class ProductServiceRepositoryImp implements ProductServiceRepository{
	private ProductRepository productRpoesitory=new ProductRepositoryImp();
	@Override
	public void createProductTable() {
		this.productRpoesitory.createProductTable();
		
	}

	@Override
	public void saveProduct(Product product) {
		this.productRpoesitory.saveProduct(product);
		
	}

	@Override
	public void updateProduct(Product product) {
		this.productRpoesitory.updateProduct(product);
		
		
	}

	@Override
	public void deleteUserProduct(int productId) {
		this.productRpoesitory.deleteUserProduct(productId);
		
	}

	@Override
	public void deleteProductById(int productId) {
		this.productRpoesitory.deleteUserProduct(productId);
		
	}

	@Override
	public Product findProductById(int productId) {
		
		return this.productRpoesitory.findProductById(productId);
	}

	@Override
	public List<Product> findProducts() {
		
		return this.productRpoesitory.findProducts();
	}

}
