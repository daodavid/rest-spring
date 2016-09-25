package com.repositoryMySql.dao;

import java.util.List;

import javax.ejb.Local;

import com.library.entity.Book;
import com.library.entity.User;

@Local
public interface Dao {
   void insert(User user);
   User get(String username);
   void update(String username);
   void deleteUser(String username);
   List<Book> getUserBooks(String username);
   List<Book> getBooks();
   void bayBook(String username,Book book);
   void addBook(String name);
   void addBookUser(String nameBook,String username);
}
