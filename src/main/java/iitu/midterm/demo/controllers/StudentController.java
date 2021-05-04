package iitu.midterm.demo.controllers;

import iitu.midterm.demo.entities.Book;
import iitu.midterm.demo.entities.Student;
import iitu.midterm.demo.services.implement.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    public boolean login(String username, String password) {
        return studentService.checkStudentAuthInfo(username, password);
    }

    public Student getStudent(String username) {
        return studentService.getStudent(username);
    }

    public void addBookInBorrowedBooks(String username, Book book) {
        studentService.addBookInBorrowedBooks(username, book);
    }

    public void deleteBookInBorrowedBooks(String username, Book book) {
        studentService.removeBookInBorrowedBooks(username, book);
    }
}
