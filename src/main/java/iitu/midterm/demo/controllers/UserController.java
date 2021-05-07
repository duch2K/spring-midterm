package iitu.midterm.demo.controllers;

import iitu.midterm.demo.entities.Book;
import iitu.midterm.demo.entities.User;
import iitu.midterm.demo.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService iUserService;

    // GET
    @GetMapping("")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(iUserService.getAll());
    }

    // POST
    @PostMapping("/create")
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        return ResponseEntity.ok(iUserService.createNew(user));
    }

    // PATCH
    @PatchMapping("/{id}/update/username")
    public ResponseEntity<?> updateUserName(@PathVariable("id") Long id, @RequestBody String username) {
        return ResponseEntity.ok(iUserService.updateUsername(id, username));
    }

//    @PatchMapping("/{id}/update/add-book-to-favorites")
//    public ResponseEntity<?> addBookToFavorites(@PathVariable("id") Long id, @RequestBody Book book) {
//        return ResponseEntity.ok(iUserService.addBookToFavorites(id, book));
//    }
//
//    // DELETE
//    @DeleteMapping("/{id}/delete/favoriteBooks")
//    public ResponseEntity<?> deleteBookFromFavoriteBook(@PathVariable("id") Long id, @RequestBody Book book) {
//        return ResponseEntity.ok(iUserService.deleteBookFromFavorites(id, book));
//    }
}

//    public void addBookInBorrowedBooks(String username, Book book) {
//        userService.addBookInBorrowedBooks(username, book);
//    }
//
//    public void deleteBookInBorrowedBooks(String username, Book book) {
//        userService.removeBookInBorrowedBooks(username, book);
//    }
