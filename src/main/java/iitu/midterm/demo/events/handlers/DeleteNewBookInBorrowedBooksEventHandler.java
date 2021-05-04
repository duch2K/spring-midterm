package iitu.midterm.demo.events.handlers;

import iitu.midterm.demo.events.DeleteBookInBorrowedBooksEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DeleteNewBookInBorrowedBooksEventHandler implements ApplicationListener<DeleteBookInBorrowedBooksEvent> {

    @Override
    public void onApplicationEvent(DeleteBookInBorrowedBooksEvent deleteBookInBorrowedBooksEvent) {
        System.out.println("\nStudent delete book in borrowed books.");
        System.out.println("Student: " + deleteBookInBorrowedBooksEvent.getStudent().getName());
        System.out.println("Book: " + deleteBookInBorrowedBooksEvent.getBook().getInfo());
    }
}
