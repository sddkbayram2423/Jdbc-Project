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
import com.proje.model.Brand;
import com.proje.queries.BrandQueries;

import com.proje.repository.BrandRepository;

public class BrandRepositoryImp implements BrandRepository{
	
	private static Logger logger=LogManager.getLogger();
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	private ResultSet resultSet=null;
	
	@Override
	public void createBrandTable()  {
		connection=DBConnection.getConnec();
		try {
			preparedStatement=connection.prepareStatement(BrandQueries.createTableBrandQuery);
			preparedStatement.execute();
			logger.info("Tablo oluþturma baþarýlý");
			
		} catch (SQLException e) {
			logger.warn("Tablo oluþturma hatasý "+e);
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}	
	}

	@Override
	public void saveBrand(Brand brand) {
		connection=DBConnection.getConnec();
		
		try {
			preparedStatement=connection.prepareStatement(BrandQueries.saveBrandQery);
			preparedStatement.setInt(1, brand.getBrandId());
			preparedStatement.setString(2, brand.getBrandName());
			
			
			preparedStatement.execute();
			
			logger.info("Brand kaydetme baþarýlý");
		} catch (SQLException e) {
			logger.info("Brand kaydetme hatasý");
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}	
		
	}


	@Override
	public Brand findBrandById(int id) {
		connection=DBConnection.getConnec();
		Brand brand=null;
		
		try {
			preparedStatement=connection.prepareStatement(BrandQueries.findBrandByIdQery);
			preparedStatement.setInt(1, id);
			resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				brand=new Brand(resultSet.getInt(1), resultSet.getString(2));
			
			}
			if(brand!=null) {
				logger.info(id+ "li Brand bulundu");
			
			}else {
				logger.info(id+ "li Brand mevcut deðildir");
			}
			
			
		} catch (SQLException e) {
			logger.info("Brand bulma hatasý "+e);
			return null;
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}	
		return brand;
	}

	@Override
	public List<Brand> listBrands() {
		connection=DBConnection.getConnec();
		List<Brand> brands=new ArrayList<Brand>();
		
		try {
			preparedStatement=connection.prepareStatement(BrandQueries.listBrandsQery);
			resultSet=preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				brands.add(new Brand(resultSet.getInt(1), resultSet.getString(2)));
			}
			logger.info("Brand listesi oluþturma baþarýlý");
			
			
		} catch (SQLException e) {
			logger.info("Brand listesi oluþturma hatasý "+e);
			return null;
		}finally {
			DBConnection.closeConnection(connection, preparedStatement, resultSet);
			
		}	
		return brands;
	}

}
