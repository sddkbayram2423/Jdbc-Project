package com.proje.Test;

import java.util.ArrayList;

import java.util.Calendar;

import java.util.Date;
import java.util.List;

import com.proje.model.Brand;
import com.proje.model.Category;
import com.proje.model.Product;
import com.proje.model.User;
import com.proje.service.BrandServiceRepository;
import com.proje.service.CategoryServiceRepository;
import com.proje.service.ProductServiceRepository;
import com.proje.service.UserServiceRepository;
import com.proje.serviceImp.BrandServiceRepositoryImp;
import com.proje.serviceImp.CategoryServiceRepositoryImp;
import com.proje.serviceImp.ProductServiceRepositoryImp;
import com.proje.serviceImp.UserServiceRepositoryImp;

public class TestApp {

	public static void main(String[] args) {
		
			
	
	}
	public static void brandTest() {

		BrandServiceRepository brandServiceRepository=new BrandServiceRepositoryImp();
			
		Brand brand=new Brand(1, "APPLE");
		Brand brand1=new Brand(2, "SAMSUNG");
		Brand brand2=new Brand(3, "LENOVA");
		Brand brand3=new Brand(4, "LG");
		Brand brand4=new Brand(5, "SONY");
		
		brandServiceRepository.saveBrand(brand);
		brandServiceRepository.saveBrand(brand1);
		brandServiceRepository.saveBrand(brand2);
		brandServiceRepository.saveBrand(brand3);
		brandServiceRepository.saveBrand(brand4);
		
		
		List<Brand> brands=brandServiceRepository.listBrands();
	
		for(Brand brand5:brands) {
			System.out.println(brand5);
		}
		
		
		System.out.println(brandServiceRepository.findBrandById(4));
		
	}
	public static void categoryTest() {

		
		CategoryServiceRepository repository=new CategoryServiceRepositoryImp();
		
		Category category=new Category(101, "Telefon");
		Category category1=new Category(102, "Tablet");
		Category category2=new Category(103, "Tv");
		Category category3=new Category(104, "MP4");
		
		repository.saveCategory(category);
		repository.saveCategory(category1);
		repository.saveCategory(category2);
		repository.saveCategory(category3);
		
		List<Category> categories=repository.listCategories();
		
		for(Category category6:categories) {
			System.out.println(category6);
		}
		
		
		System.out.println(repository.findCategoryById(105));

	}
	
	public static void productTest() {
		
		ProductServiceRepository productServiceRepository=new ProductServiceRepositoryImp();
		
		
		Category category=new Category(101, "Telefon");
		Category category1=new Category(102, "Tablet");
		Category category2=new Category(103, "Tv");
		Category category3=new Category(104, "MP4");
		
		Brand brand=new Brand(1, "APPLE");
		Brand brand1=new Brand(2, "SAMSUNG");
		Brand brand2=new Brand(3, "LENOVA");
		Brand brand3=new Brand(4, "LG");
		Brand brand4=new Brand(5, "SONY");
		
		Product product=new Product(1, "IPONE 7", 3800, 3, null, null, category, brand);
		Product product1=new Product(2, "Sony Xperia", 2700, 2, new Date(), new Date(), category, brand4);
		Product product2=new Product(3, "MAC i5", 8000, 1, null, null, category, brand);
		Product product3=new Product(4, "LG 8", 3800, 0, null, null, category, brand3);
		Product product4=new Product(5, "SAMSUNG S8+", 3800, 8, null, null, category, brand1);
		Product product5=new Product(6, "IPONE XR", 12000, 1, null, null, category, brand);
		Product product6=new Product(7, "SONY tablet", 1200, 3, null, null,category1,brand4);
		Product product7=new Product(8, "IPODE", 800, 3, null, null, category1,brand);
		Product product8=new Product(9, "Xa mp4", 100, 11,null, null, category3,brand4);
		Product product9=new Product(10, "V330 ", 3800, 4, null, null, category, brand2);
		Product product10=new Product(11, "LCD TV", 3500,0,null, null, category2,brand2);
		
		productServiceRepository.saveProduct(product);
		productServiceRepository.saveProduct(product1);
		productServiceRepository.saveProduct(product2);
		productServiceRepository.saveProduct(product3);
		productServiceRepository.saveProduct(product4);
		productServiceRepository.saveProduct(product5);
		productServiceRepository.saveProduct(product6);
		productServiceRepository.saveProduct(product7);
		productServiceRepository.saveProduct(product8);
		productServiceRepository.saveProduct(product9);
		productServiceRepository.saveProduct(product10);
		
//		System.out.println(productServiceRepository.findProductById(2));
		
//		Product product11=new Product(11, "LCD PLAZMA", 8500,0,null, null, category2,brand2);
//		productServiceRepository.updateProduct(product11);
		
//		List<Product> products=productServiceRepository.findProducts();
//		for(Product pro:products) {System.out.println(pro);}
		
//		productServiceRepository.deleteUserProduct(1);

	
	}
	public static Calendar crateDate(int year,int month,int day) {
		
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		
		return calendar;
	}
	
	public static void userTest() {
		
		UserServiceRepository repository=new UserServiceRepositoryImp();
		
		
		Category category=new Category(101, "Telefon");
		Category category1=new Category(102, "Tablet");
		Category category2=new Category(103, "Tv");
		Category category3=new Category(104, "MP4");
		
		Brand brand=new Brand(1, "APPLE");
		Brand brand1=new Brand(2, "SAMSUNG");
		Brand brand2=new Brand(3, "LENOVA");
		Brand brand3=new Brand(4, "LG");
		Brand brand4=new Brand(5, "SONY");
		
		Product product=new Product(1, "IPONE 7", 3800, 3, null, null, category, brand);
		Product product1=new Product(2, "Sony Xperia", 2700, 2, new Date(), new Date(), category, brand4);
		Product product2=new Product(3, "MAC i5", 8000, 1, null, null, category, brand);
		Product product3=new Product(4, "LG 8", 3800, 0, null, null, category, brand3);
		Product product4=new Product(5, "SAMSUNG S8+", 3800, 8, null, null, category, brand1);
		Product product5=new Product(6, "IPONE XR", 12000, 1, null, null, category, brand);
		Product product6=new Product(7, "SONY tablet", 1200, 3, null, null,category1,brand4);
		Product product7=new Product(8, "IPODE", 800, 3, null, null, category1,brand);
		Product product8=new Product(9, "Xa mp4", 100, 11,null, null, category3,brand4);
		Product product9=new Product(10, "V330 ", 3800, 4, null, null, category, brand2);
		Product product10=new Product(11, "LCD TV", 3500,0,null, null, category2,brand2);
		
		
		List<Product> products=new ArrayList<Product>();
		products.add(product);
		products.add(product2);
		products.add(product5);
		products.add(product3);
		
		List<Product> products1=new ArrayList<Product>();
		products1.add(product4);
		products1.add(product8);
		products1.add(product5);
		products1.add(product3);
		
		List<Product> products2=new ArrayList<Product>();
		products2.add(product10);
		products2.add(product2);
		products2.add(product9);
		products2.add(product3);
		products2.add(product6);
		
		List<Product> products3=new ArrayList<Product>();
		products3.add(product1);
		products3.add(product7);
		products3.add(product5);

		
		User user=new User(1, "Ali", "Kara", "Karaman", "Türikey");
		user.setProducts(products1);
		
		User user1=new User(2, "Nazlý", "Birlik", "Muðla", "Türikey");
		user1.setProducts(products3);
		
		User user2=new User(3, "Bahar", "Baran", "Ýstanbul", "Türikey");
		user2.setProducts(products2);
		
		User user3=new User(4, "Burhan", "Sarý", "Konya", "Türikey");
		user3.setProducts(products);
		
		User user4=new User(5, "Ayten", "Salih", "Ýzmir", "Türikey");
		user4.setProducts(products3);
		
		User user5=new User(6, "Ali", "Düver", "Burse", "Türikey");
		user5.setProducts(products1);
		
		repository.saveUse(user);
		repository.saveUse(user1);
		repository.saveUse(user2);
		repository.saveUse(user3);
		repository.saveUse(user4);
		repository.saveUse(user5);
		
		repository.saveUserProduct(1, 1);
		repository.saveUserProduct(2, 3);
		repository.saveUserProduct(3, 5);
		repository.saveUserProduct(4, 7);
		repository.saveUserProduct(5, 9);
		repository.saveUserProduct(6, 2);
		
//		repository.deleteUserById(2);
	}

}
