package com.proje.repositoryImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.proje.DBConnection.DBConnection;

import com.proje.model.Category;

import com.proje.queries.CategoryQueries;
import com.proje.repository.CategoryRepository;

public class CategoryRepositoryImp implements CategoryRepository {
	private static Logger logger=LogManager.getLogger();
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	private ResultSet resultSet=null;

	@Override
	public void createCategoryTable() {
		connection=DBConnection.getConnec();
		try {
			preparedStatement=connection.prepareStatement(CategoryQueries.createTableCategoryQuery);
			preparedStatement.execute();
			logger.info("Tablo oluþturma baþarýlý");
			
		} catch (SQLException e) {
			logger.warn("Tablo oluþturma hatasý "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}	
	}

	@Override
	public void saveCategory(Category category) {
		connection=DBConnection.getConnec();
		
		try {
			preparedStatement=connection.prepareStatement(CategoryQueries.saveCategoryQuery);
			preparedStatement.setInt(1, category.getCategoryId());
			preparedStatement.setString(2, category.getCategoryName());
			
			
			preparedStatement.execute();
			
			logger.info("Category kaydetme baþarýlý");
		} catch (SQLException e) {
			logger.info("Category kaydetme hatasý");
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}	
	}

	@Override
	public Category findCategoryById(int id) {
		connection=DBConnection.getConnec();
		Category category=null;
		
		try {
			preparedStatement=connection.prepareStatement(CategoryQueries.findCategoryByIdQery);
			preparedStatement.setInt(1, id);
			resultSet=preparedStatement.executeQuery();
		
			while (resultSet.next()) {
			
				category=new Category(resultSet.getInt(1), resultSet.getString(2));
				
			
			}
			if(category!=null) {
				
				logger.info(id+ "li category bulundu");
			
			}else {
				logger.info(id+ "li category mevcut deðildir");
			}
			
			
		} catch (SQLException e) {
			logger.info("category bulma hatasý "+e);
			return null;
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}	
		return category;
	}

	@Override
	public List<Category> listCategories() {
		connection=DBConnection.getConnec();
		List<Category> categories=new ArrayList<Category>();
		
		try {
			preparedStatement=connection.prepareStatement(CategoryQueries.listCategoriesQery);
			resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				categories.add(new Category(resultSet.getInt(1), resultSet.getString(2)));
			}
			logger.info("Category listesi oluþturma baþarýlý");
			
			
		} catch (SQLException e) {
			logger.info("Category listesi oluþturma hatasý "+e);
			return null;
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}	
		return categories;
	}

}
