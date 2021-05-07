package iitu.midterm.demo.services;

import iitu.midterm.demo.entities.Book;
import iitu.midterm.demo.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    List<Book> findBookByNameOrAuthor(String name, String author);
    Book getBookById(Long id);
    Book createNew(Book book);
    Book update(Book book);
    void deleteBookById(Long id);
//    List<Book> getBooksByUser(User user);
//    List<Book> getBooksByNotUser(User user);
}
