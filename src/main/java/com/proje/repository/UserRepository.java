package com.proje.repository;

import java.util.List;

import com.proje.model.User;

public interface UserRepository {
	
	public void createUserTable();
	
	public void createTableUser_Product();
	
	public User saveUse(User user);
	
	public void saveUserProduct(int userId,int productId);
	
	public User updateUser(User user);

	public void deleteUserById(int userId);
	
	public User findUserById(int userId);
	
	public List<User> listUsers();
	
	public List<User> findUserByName(String name);
	
	public User findUsersProductById(int userId);
	

	
	
}
