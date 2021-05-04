package iitu.midterm.demo.services;

import iitu.midterm.demo.entities.Book;
import iitu.midterm.demo.entities.Student;

public interface IStudentService {
    boolean checkStudentAuthInfo(String username, String password);
    Student getStudent(String username);
    void addBookInBorrowedBooks(String username, Book book);
    void removeBookInBorrowedBooks(String username, Book book);
}
