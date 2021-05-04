package iitu.midterm.demo.events;

import iitu.midterm.demo.entities.Book;
import iitu.midterm.demo.entities.Student;
import org.springframework.context.ApplicationEvent;

public class AddNewBookInBorrowedBooksEvent extends ApplicationEvent {
    private Student student;
    private Book book;

    public AddNewBookInBorrowedBooksEvent(Object source, Student student, Book book) {
        super(source);
        this.student = student;
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public Book getBook() {
        return book;
    }
}