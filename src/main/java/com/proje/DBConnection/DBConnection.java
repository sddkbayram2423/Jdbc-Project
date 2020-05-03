package com.proje.DBConnection;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConnection {
	private static Logger logger = LogManager.getLogger();
	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	static {

		Properties properties = new Properties();
		try {
			InputStream inputStream = new FileInputStream("src/main/resources/db.properties");
			properties.load(inputStream);
			driver = properties.getProperty("db.driver");
			url = properties.getProperty("db.url");
			username = properties.getProperty("db.username");
			password = properties.getProperty("db.password");
			logger.info("Propertires Dosyasý okumasý baþarýlý");

		} catch (IOException e) {
			logger.warn("Propertires Dosyasý okuma hatasý " + e);

		}
	}

	public static Connection getConnec() {
		try {
			Class.forName(driver);

			logger.info("Driver baþarýlý");
		} catch (Exception e) {
			logger.warn("Propertires Dosyasý okuma hatasý " + e);
		}
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, username, password);
			logger.info("Mysql connection baðlatýsý baþarýlý bir þekilde oluþturuldu");
		} catch (Exception e) {
			logger.warn("Mysql connection baðlantý hatasý" + e);
		}
		return connection;
	}

	public static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {

		if (connection != null) {

			try {
				connection.close();
				logger.info("Connection kapatma baþarýlý");
			} catch (SQLException e) {
				logger.info("Connection kapatma hatasý " + e);
			}

		}
		if (preparedStatement != null) {

			try {
				connection.close();
				logger.info("PreparedStatement kapatma baþarýlý");
			} catch (SQLException e) {
				logger.info("PreparedStatement kapatma hatasý " + e);
			}

		}
		if (resultSet != null) {

			try {
				connection.close();
				logger.info("ResultSet kapatma baþarýlý");
			} catch (SQLException e) {
				logger.info("ResultSet kapatma hatasý " + e);
			}

		}

	}

}
