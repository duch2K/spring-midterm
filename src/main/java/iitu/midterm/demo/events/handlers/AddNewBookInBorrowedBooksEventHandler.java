package iitu.midterm.demo.events.handlers;

import iitu.midterm.demo.events.AddNewBookInBorrowedBooksEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AddNewBookInBorrowedBooksEventHandler implements ApplicationListener<AddNewBookInBorrowedBooksEvent> {
    @Override
    public void onApplicationEvent(AddNewBookInBorrowedBooksEvent addNewBookInBorrowedBooksEvent) {
        System.out.println("\nStudent add new book in borrowed books.");
        System.out.println("Student: " + addNewBookInBorrowedBooksEvent.getStudent().getName());
        System.out.println("Book: " + addNewBookInBorrowedBooksEvent.getBook().getInfo());
    }
}