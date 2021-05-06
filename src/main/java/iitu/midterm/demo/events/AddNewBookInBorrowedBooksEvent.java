package iitu.midterm.demo.events;

import iitu.midterm.demo.entities.Book;
import iitu.midterm.demo.entities.User;
import org.springframework.context.ApplicationEvent;

public class AddNewBookInBorrowedBooksEvent extends ApplicationEvent {
    private User user;
    private Book book;

    public AddNewBookInBorrowedBooksEvent(Object source, User user, Book book) {
        super(source);
        this.user = user;
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }
}
