package iitu.midterm.demo.services.implement;

import iitu.midterm.demo.entities.Book;
import iitu.midterm.demo.entities.User;
import iitu.midterm.demo.events.AddNewBookInBorrowedBooksEvent;
import iitu.midterm.demo.events.DeleteBookInBorrowedBooksEvent;
import iitu.midterm.demo.repositories.BookRepository;
import iitu.midterm.demo.repositories.UserRepository;
import iitu.midterm.demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService, UserDetailsService, ApplicationEventPublisherAware {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private ApplicationEventPublisher eventPublisher;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User updateUsername(Long id, String username) {
        User user = userRepository.getOne(id);
        user.setUsername(username);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User createNew(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User by username=" + username + " not found!");
        }
        return user;
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
//    @Override
//    public void addBookInBorrowedBooks(String username, Book book) {
//        User user = userRepository.getUserByUsername(username);
//        book.setQuantity(book.getQuantity() - 1);
//        user.getBooks().add(book);
//        userRepository.save(user);
//        this.eventPublisher.publishEvent(new AddNewBookInBorrowedBooksEvent(this, user, book));
//    }

//    @Override
//    public void removeBookInBorrowedBooks(String username, Book book) {
//        User user = userRepository.getUserByUsername(username);
//        book.setQuantity(book.getQuantity() + 1);
//
//        for (int i = 0; i < user.getBooks().size(); i++) {
//            if (user.getBooks().get(i).getId() == book.getId()) {
//                user.getBooks().remove(i);
//                break;
//            }
//        }
//
