package com.proje.repositoryImp;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.proje.DBConnection.DBConnection;
import com.proje.model.Brand;
import com.proje.model.Category;
import com.proje.model.Product;
import com.proje.model.User;

import com.proje.queries.UserQueries;
import com.proje.repository.UserRepository;

public class UserRepositoryImp implements UserRepository {
	private static Logger logger=LogManager.getLogger();
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	private ResultSet resultSet=null;

	@Override
	public void createUserTable() {
		connection=DBConnection.getConnec();
		
		try {
			preparedStatement=connection.prepareStatement(UserQueries.createTableUserQuery);
			preparedStatement.execute();
			
			logger.info("Tablo oluþturma baþarýlý");
		} catch (SQLException e) {
			logger.warn("Tablo oluþturma hatasý "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}
	}

	@Override
	public void createTableUser_Product() {
		connection=DBConnection.getConnec();
		
		try {
			preparedStatement=connection.prepareStatement(UserQueries.createTableUser_ProductQuery);
			preparedStatement.execute();
			
			logger.info("Tablo oluþturma baþarýlý");
		} catch (SQLException e) {
			logger.warn("Tablo oluþturma hatasý "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}
		
	}

	@Override
	public User saveUse(User user) {
		connection=DBConnection.getConnec();
	
		try {
		
			preparedStatement=connection.prepareStatement(UserQueries.saveUserQuery);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getLastname());
			preparedStatement.setString(4, user.getCity());
			preparedStatement.setString(5, user.getCountry());
			
			
			preparedStatement.execute();
			
			logger.info("User ekleme baþarýlý");
		} catch (SQLException e) {
			logger.warn("User ekleme hatasý "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}
		
		return user;
	}

	@Override
	public void saveUserProduct(int userId, int productId) {

		connection=DBConnection.getConnec();
		
		try {
			preparedStatement=connection.prepareStatement(UserQueries.saveUser_ProductQery);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, productId);
	
			preparedStatement.executeUpdate();
			
			logger.info("UserProduct ekleme baþarýlý");
		} catch (SQLException e) {
			logger.warn("UserProduct ekleme hatasý "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}
		
		
	}

	@Override
	public User updateUser(User user) 
{
		connection=DBConnection.getConnec();
		
		try {
		
			preparedStatement=connection.prepareStatement(UserQueries.saveUserQuery);
			
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getCity());
			preparedStatement.setString(4, user.getCountry());
			preparedStatement.setInt(5, user.getId());
			
			preparedStatement.execute();
			
			logger.info("User güncelleme baþarýlý");
		} catch (SQLException e) {
			logger.warn("User güncelleme hatasý "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}
		
		return user;
	}

	@Override
	public void deleteUserById(int userId) {
		connection=DBConnection.getConnec();
		
		try {
			preparedStatement=connection.prepareStatement(UserQueries.deleteUser_ProductQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
			
			preparedStatement=connection.prepareStatement(UserQueries.deleteUserQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
			
			logger.info("User silme baþarýlý");
		} catch (SQLException e) {
			logger.warn("User silme hatasý "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}
		
	}

	@Override
	public User findUserById(int userId) {
		connection=DBConnection.getConnec();
		User user=null;
		try {
			preparedStatement=connection.prepareStatement(UserQueries.findUserByIdQuery);
			preparedStatement.setInt(1, userId);
			resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				user=new User(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
				
			
			}
			if(user!=null) {
				
				logger.info(userId+ "li user bulundu");
			
			}else {
				logger.info(userId+ "li user mevcut deðildir");
			}
			
	
			logger.info("User bulma baþarýlý");
		} catch (SQLException e) {
			logger.warn("User bulma hatasý "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}
		return user;
	}

	@Override
	public List<User> listUsers() {
		connection=DBConnection.getConnec();
		List<User> users=new ArrayList<User>();
		try {
			preparedStatement=connection.prepareStatement(UserQueries.listUsersQuery);
			resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				users.add(new User(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
				
			
			}
		
			logger.info("User liste baþarýlý");
		} catch (SQLException e) {
			logger.warn("User liste hatasý "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}
		return users;
	}

	@Override
	public List<User> findUserByName(String name) {
		connection=DBConnection.getConnec();
		List<User> users=new ArrayList<User>();
		try {
			preparedStatement=connection.prepareStatement(UserQueries.findUserByNameQuery);
			preparedStatement.setString(1, name);
			resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				users.add(new User(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
				
			
			}
		
			logger.info("User liste baþarýlý");
		} catch (SQLException e) {
			logger.warn("User liste hatasý "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}
		return users;
	}

	@Override
	public User findUsersProductById(int userId) {
		
//		public static final String findUser_ProductByIdQery="select *from user u left outer join user_product up on(u.userId=up.userId)"
//				+ "left join product p on(p.productId=up.productId) "
//				+ "left join category c on(p.categoryId=c.categoryId) "
//				+ "left join brand c on(p.brandId=c.brandId) where userId=?";
		
		
		connection=DBConnection.getConnec();
		User user=null;
		List<Product> products=new ArrayList<Product>();
		try {
			preparedStatement=connection.prepareStatement(UserQueries.findUser_ProductByIdQery);
			preparedStatement.setInt(1, userId);
			boolean durum=true;
			resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				if(durum) {
					user=new User(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5));
					durum=false;
					
				}
			
				
				
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
			user.setProducts(products);
			logger.info("User liste baþarýlý");
		} catch (SQLException e) {
			logger.warn("User liste hatasý "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}
		return user;
	}

}
