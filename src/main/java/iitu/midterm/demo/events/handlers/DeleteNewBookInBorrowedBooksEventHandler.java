package iitu.midterm.demo.events.handlers;

import iitu.midterm.demo.events.DeleteBookInBorrowedBooksEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DeleteNewBookInBorrowedBooksEventHandler implements ApplicationListener<DeleteBookInBorrowedBooksEvent> {

    @Override
    public void onApplicationEvent(DeleteBookInBorrowedBooksEvent deleteBookInBorrowedBooksEvent) {
        System.out.println("\nUser delete book in borrowed books.");
        System.out.println("User: " + deleteBookInBorrowedBooksEvent.getUser().getName());
        System.out.println("Book: " + deleteBookInBorrowedBooksEvent.getBook().getAuthor()
                  + " - " + deleteBookInBorrowedBooksEvent.getBook().getTitle());
    }
}
