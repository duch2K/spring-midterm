package iitu.midterm.demo.controllers;

import iitu.midterm.demo.entities.Book;
import iitu.midterm.demo.entities.Student;
import iitu.midterm.demo.services.implement.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    public List<Book> getBooksByStudent(Student student) {
        return bookService.getBooksByStudent(student);
    }

    public List<Book> getBooksByNotStudent(Student student) {
        return bookService.getBooksByNotStudent(student);
    }
}
