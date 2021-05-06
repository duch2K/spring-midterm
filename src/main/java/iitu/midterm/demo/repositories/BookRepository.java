package iitu.midterm.demo.repositories;

import iitu.midterm.demo.entities.Book;
import iitu.midterm.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book getBookById(Long id);
    List<Book> getBooksByNameContainsOrAuthorContains(String name, String author);
//    List<Book> getBooksByUserContains(User user);
//    List<Book> getBooksByUserNotContainingAndQuantityIsNot(User user, int quantity);
}
