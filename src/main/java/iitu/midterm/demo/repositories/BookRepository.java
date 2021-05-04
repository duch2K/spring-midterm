package iitu.midterm.demo.repositories;

import iitu.midterm.demo.entities.Book;
import iitu.midterm.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> getAllBy();
    List<Book> getBooksByStudentsContains(Student student);
    List<Book> getBooksByStudentsNotContainingAndQuantityIsNot(Student student, int quantity);
}
