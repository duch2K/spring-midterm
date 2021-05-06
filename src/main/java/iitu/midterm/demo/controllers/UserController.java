package iitu.midterm.demo.controllers;

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
    @GetMapping("/all")
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
    public ResponseEntity<?> updateUserPassword(@PathVariable("id") Long id, @RequestBody String username) {
        return ResponseEntity.ok(iUserService.updateUsername(id, username));
    }
}

//    public void addBookInBorrowedBooks(String username, Book book) {
//        userService.addBookInBorrowedBooks(username, book);
//    }
//
//    public void deleteBookInBorrowedBooks(String username, Book book) {
//        userService.removeBookInBorrowedBooks(username, book);
//    }
