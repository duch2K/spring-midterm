package iitu.midterm.demo.services.implement;

import iitu.midterm.demo.entities.Book;
import iitu.midterm.demo.entities.Student;
import iitu.midterm.demo.repositories.BookRepository;
import iitu.midterm.demo.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.getAllBy();
    }

    @Override
    public List<Book> getBooksByStudent(Student student) {
        return bookRepository.getBooksByStudentsContains(student);
    }

    @Override
    public List<Book> getBooksByNotStudent(Student student) {
        return bookRepository.getBooksByStudentsNotContainingAndQuantityIsNot(student, 0);
    }
}
