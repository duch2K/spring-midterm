package iitu.midterm.demo.services;

import iitu.midterm.demo.entities.Book;
import iitu.midterm.demo.entities.Student;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    List<Book> getBooksByStudent(Student student);
    List<Book> getBooksByNotStudent(Student student);
}
