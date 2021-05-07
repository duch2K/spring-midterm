package iitu.midterm.demo.services.implement;

import iitu.midterm.demo.entities.Book;
import iitu.midterm.demo.entities.User;
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
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findBookByNameOrAuthor(String name, String author) {
        return bookRepository.getBooksByTitleContainsOrAuthorContains(name, author);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.getBookById(id);
    }

    @Override
    public Book createNew(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public Book update(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

//    @Override
//    public List<Book> getBooksByUser(User user) {
//        return bookRepository.;
//    }

//    @Override
//    public List<Book> getBooksByNotUser(User user) {
//        return null;
//    }
}
