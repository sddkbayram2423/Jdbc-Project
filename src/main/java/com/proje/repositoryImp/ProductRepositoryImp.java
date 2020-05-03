package com.proje.repositoryImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.proje.DBConnection.DBConnection;
import com.proje.model.Brand;
import com.proje.model.Category;
import com.proje.model.Product;
import com.proje.queries.ProductQueries;
import com.proje.repository.ProductRepository;

public class ProductRepositoryImp implements ProductRepository {
	private static Logger logger=LogManager.getLogger();
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	private ResultSet resultSet=null;

	@Override
	public void createProductTable() {
		connection=DBConnection.getConnec();
		
		try {
			preparedStatement=connection.prepareStatement(ProductQueries.createTableQuery);
			preparedStatement.execute();
			
			logger.info("Tablo oluþturma baþarýlý");
		} catch (SQLException e) {
			logger.warn("Tablo oluþturma hatasý "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}
		
		
	}

	@Override
	public void saveProduct(Product product) {
		connection=DBConnection.getConnec();

		try {
			LocalDateTime localDateTime = LocalDateTime.now();
			preparedStatement=connection.prepareStatement(ProductQueries.saveProductQery);
			preparedStatement.setInt(1, product.getProductID());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setDouble(3, product.getUnitPrice());
			preparedStatement.setInt(4, product.getAvaible());
			preparedStatement.setTimestamp(5,Timestamp.valueOf(localDateTime));
			preparedStatement.setDate(6,null);
			preparedStatement.setInt(7, product.getCategory().getCategoryId());
			preparedStatement.setInt(8, product.getBrand().getBrandId());
			
			
			preparedStatement.execute();
			
			logger.info("Product ekleme baþarýlý");
		} catch (SQLException e) {
			logger.warn("Product ekleme hatasý "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}
		
	}

	@Override
	public void updateProduct(Product product) {
		connection=DBConnection.getConnec();

		try {
			LocalDateTime localDateTime = LocalDateTime.now();
			preparedStatement=connection.prepareStatement(ProductQueries.updateProductQery);
			preparedStatement.setString(1, product.getProductName());
			preparedStatement.setInt(2, product.getAvaible());
			preparedStatement.setDouble(3, product.getUnitPrice());
			preparedStatement.setTimestamp(4,Timestamp.valueOf(localDateTime));
			preparedStatement.setInt(5, product.getCategory().getCategoryId());
			preparedStatement.setInt(6, product.getBrand().getBrandId());	
			preparedStatement.setInt(7, product.getProductID());

			preparedStatement.executeUpdate();
			
			logger.info("Product güncelleme baþarýlý");
		} catch (SQLException e) {
			logger.warn("Product güncelleme hatasý "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}
	}

	@Override
	public void deleteUserProduct(int productId) {
		connection=DBConnection.getConnec();

		try {
			preparedStatement=connection.prepareStatement(ProductQueries.deleteProductByIdQery);
			preparedStatement.setInt(1, productId);
			preparedStatement.executeUpdate();
			
			preparedStatement=connection.prepareStatement(ProductQueries.deleteUser_ProductQery);
			preparedStatement.setInt(1, productId);
			preparedStatement.executeUpdate();
			
			
			
			logger.info("ProductUSer silme baþarýlý");
		} catch (SQLException e) {
			logger.warn("ProductUSer silme hatasý "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}
		
	}

	@Override
	public void deleteProductById(int productId) {
		connection=DBConnection.getConnec();

		try {
			
			preparedStatement=connection.prepareStatement(ProductQueries.deleteProductByIdQery);
			preparedStatement.setInt(1, productId);
			
			preparedStatement.executeUpdate();
			
			logger.info("Product silme baþarýlý");
		} catch (SQLException e) {
			logger.warn("Product silme hatasý "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}
	}

	@Override
	public Product findProductById(int productId) {
		connection = DBConnection.getConnec();
		Product product = null;

		try {

			preparedStatement = connection.prepareStatement(ProductQueries.findProductByIdQery);
			preparedStatement.setInt(1, productId);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {

				int id = resultSet.getInt("productID");
				String productName = resultSet.getString("productName");
				double unitPrice = resultSet.getDouble("unitPrice");
				int avaible = resultSet.getInt("avaible");
				Date addDate = resultSet.getDate("addDate");
				Date updateDate = resultSet.getDate("updateDate");
				Category category = new Category(resultSet.getInt("categoryId"), resultSet.getString("categoryName"));
				Brand brand = new Brand(resultSet.getInt("brandID"), resultSet.getString("brandName"));

				product = new Product(id, productName, unitPrice, avaible, addDate, updateDate, category, brand);

			}
			if (product != null) {

				logger.info(productId + "li Product bulundu");

			} else {
				logger.info(productId + "li Product mevcut deðildir");
			}

			logger.info("Product bulma baþarýlý");
		} catch (SQLException e) {
			logger.warn("Product bulma hatasý " + e);
		} finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);

		}
		return product;
		
	}

	@Override
	public List<Product> findProducts() {
		connection = DBConnection.getConnec();
		List<Product> products = new ArrayList<Product>();

		try {

			preparedStatement = connection.prepareStatement(ProductQueries.findProductsQery);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("productID");
				String productName = resultSet.getString("productName");
				double unitPrice = resultSet.getDouble("unitPrice");
				int avaible = resultSet.getInt("avaible");
				Date addDate = resultSet.getDate("addDate");
				Date updateDate = resultSet.getDate("updateDate");
				Category category = new Category(resultSet.getInt("categoryId"), resultSet.getString("categoryName"));
				Brand brand = new Brand(resultSet.getInt("brandID"), resultSet.getString("brandName"));

				products.add(new Product(id, productName, unitPrice, avaible, addDate, updateDate, category, brand));

			}

		} catch (SQLException e) {
			logger.warn("Product listele hatasý " + e);
		} finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);

		}
		return products;
	}

}
