package com.proje.serviceImp;

import java.util.List;

import com.proje.model.User;
import com.proje.repository.UserRepository;
import com.proje.repositoryImp.UserRepositoryImp;
import com.proje.service.UserServiceRepository;

public class UserServiceRepositoryImp implements UserServiceRepository {
	private UserRepository userRepository=new UserRepositoryImp(); 
	@Override
	public void createUserTable() {
		this.userRepository.createUserTable();
		
	}

	@Override
	public void createTableUser_Product() {
		this.userRepository.createTableUser_Product();
		
	}

	@Override
	public User saveUse(User user) {
		
		return this.userRepository.saveUse(user);
	}

	@Override
	public void saveUserProduct(int userId, int productId) {
		this.userRepository.saveUserProduct(userId, productId);
		
	}

	@Override
	public User updateUser(User user) {
		
		return this.userRepository.updateUser(user);
	}

	@Override
	public void deleteUserById(int userId) {
		this.userRepository.deleteUserById(userId);
		
	}

	@Override
	public User findUserById(int userId) {
		
		return this.userRepository.findUserById(userId);
	}

	@Override
	public List<User> listUsers() {
		
		return this.userRepository.listUsers();
	}

	@Override
	public List<User> findUserByName(String name) {
		
		return this.userRepository.findUserByName(name);
	}

	@Override
	public  User findUsersProductById(int userId) {
		
		return this.userRepository.findUsersProductById(userId);
	}

}
