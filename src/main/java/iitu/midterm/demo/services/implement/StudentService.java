package iitu.midterm.demo.services.implement;

import iitu.midterm.demo.entities.Book;
import iitu.midterm.demo.entities.Student;
import iitu.midterm.demo.events.AddNewBookInBorrowedBooksEvent;
import iitu.midterm.demo.events.DeleteBookInBorrowedBooksEvent;
import iitu.midterm.demo.repositories.BookRepository;
import iitu.midterm.demo.repositories.StudentRepository;
import iitu.midterm.demo.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService, ApplicationEventPublisherAware {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private BookRepository bookRepository;
    private ApplicationEventPublisher eventPublisher;

    @Override
    public boolean checkStudentAuthInfo(String username, String password) {
        return studentRepository.existsStudentByUsernameAndPassword(username, password);
    }

    @Override
    public Student getStudent(String username) {
        return studentRepository.getStudentByUsername(username);
    }

    @Override
    public void addBookInBorrowedBooks(String username, Book book) {
        Student student = studentRepository.getStudentByUsername(username);
        book.setQuantity(book.getQuantity() - 1);
        student.getBooks().add(book);
        studentRepository.save(student);
        this.eventPublisher.publishEvent(new AddNewBookInBorrowedBooksEvent(this, student, book));
    }

    @Override
    public void removeBookInBorrowedBooks(String username, Book book) {
        Student student = studentRepository.getStudentByUsername(username);
        book.setQuantity(book.getQuantity() + 1);

        for (int i = 0; i < student.getBooks().size(); i++) {
            if (student.getBooks().get(i).getId() == book.getId()) {
                student.getBooks().remove(i);
                break;
            }
        }

        studentRepository.save(student);
        bookRepository.save(book);
        this.eventPublisher.publishEvent(new DeleteBookInBorrowedBooksEvent(this, student, book));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
