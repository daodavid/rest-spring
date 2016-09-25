package com.repositoryMySql.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.library.entity.Book;
import com.library.entity.Gender;
import com.library.entity.Town;
import com.library.entity.User;

@Stateless
public class DaoImp implements Dao {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/librarybase";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";
	static Connection conn = null;
	static Statement stmt = null;
	static PreparedStatement preparedStatement;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// STEP 3: Open a connection
			System.err.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void insert(User user) {
		String insertSQL = "INSERT INTO  user (username, password,town_id,gender_id) "
				+ "select ?,?,g.id,t.id from gender as g "+
				"join town as t on (t.name=?)"+
				"where g.name=?";
		

		try {
			preparedStatement = conn.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getTown().getName());
			preparedStatement.setString(4, user.getGender().getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public User get(String username) {
		User u=null;
		String selectSQL = "SELECT u.username, u.password,g.name,t.name "+
				"from user as u"+
				" join town as t on (t.id=u.town_id)"+
				" join gender as g on (g.id=u.gender_id)"+
				" where u.username=?";
		

		try {
			preparedStatement = conn.prepareStatement(selectSQL);
			preparedStatement.setString(1,username);
		
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				 u=new User(rs.getString("username"),rs.getString("password"),new Gender(rs.getString("g.name")),new Town(rs.getString("t.name"))) ;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
		
		
	}

	@Override
	public void update(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> getUserBooks(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBooks() {
		String selectSQL = "SELECT id,name from books";
		List<Book> books=new ArrayList<Book>();

		try {
		       stmt=conn.createStatement();
		
			ResultSet rs = stmt.executeQuery(selectSQL);
			while (rs.next()) {
				books.add(new Book(rs.getInt("id"),rs.getString("name")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
		
	}

	@Override
	public void bayBook(String username, Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBook(String name) {
		String insertSQL = "insert into books (name)"
				+ " values(?)";
		

		try {
			preparedStatement = conn.prepareStatement(insertSQL);
			preparedStatement.setString(1, name);
		
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addBookUser(String nameBook, String username) {
		String sql="insert into user_book (user_id,book_id)"+
	    "select u.id,b.id from user as u"+
				" join book as b on b.name=?"+
	             "where u.username=?";
		try {
			preparedStatement=conn.prepareStatement(sql);
			preparedStatement.setString(1, nameBook);
			preparedStatement.setString(2,username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
    
}
