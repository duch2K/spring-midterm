package iitu.midterm.demo.controllers;

import iitu.midterm.demo.entities.Book;
import iitu.midterm.demo.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private IBookService iBookService;

    // GET
    @GetMapping("")
    public ResponseEntity<?> findBookByNameOrAuthor(@RequestParam("name") String name, @RequestParam("author") String author) {
        return ResponseEntity.ok(iBookService.findBookByNameOrAuthor(name, author));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable() Long id) {
        return ResponseEntity.ok(iBookService.getBookById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllBooks() {
        return ResponseEntity.ok(iBookService.getAll());
    }

    // POST
    @PostMapping("/create")
    public ResponseEntity<?> createNewBook(@RequestBody Book book) {
        return ResponseEntity.ok(iBookService.createNew(book));
    }

    // PUT
    @PutMapping("/update")
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        return ResponseEntity.ok(iBookService.update(book));
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public void deleteBookById(@PathVariable("id") Long id) {
        iBookService.deleteBookById(id);
    }
}
