package iitu.midterm.demo.services;

import iitu.midterm.demo.entities.Book;
import iitu.midterm.demo.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    User createNew(User user);
    User updateUsername(Long id, String username);
    void deleteUserById(Long id);
//    User addBookToFavorites(Long userId, Book book);
//    User deleteBookFromFavorites(Long userId, Book book);
}
