package iitu.midterm.demo.events;

import iitu.midterm.demo.entities.Book;
import iitu.midterm.demo.entities.User;
import org.springframework.context.ApplicationEvent;

public class DeleteBookInBorrowedBooksEvent extends ApplicationEvent {
    private User user;
    private Book book;

    public DeleteBookInBorrowedBooksEvent(Object source, User user, Book book) {
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
