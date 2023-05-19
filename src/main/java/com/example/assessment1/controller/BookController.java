package com.example.assessment1.controller;

import com.example.assessment1.model.Book;
import com.example.assessment1.service.BookSevice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookSevice bookSevice;

    public BookController(BookSevice bookSevice) {
        this.bookSevice = bookSevice;
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookSevice.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    @GetMapping("/active")
    public List<Book> getActiveBooks() {
        return bookSevice.getActiveBooks();
    }
    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookSevice.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Short id) {
        Optional<Book> book = bookSevice.getBookById(id);
        return book.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Short id, @RequestBody Book book) {
        try {
            Book updatedBook = bookSevice.updateBook(id,book);
            return ResponseEntity.ok(updatedBook);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Short id) {
        bookSevice.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/activate/{id}")
    public ResponseEntity<Void> activateBook(@PathVariable Short id) {
        try {
            bookSevice.activateBook(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<Void> deactivateBook(@PathVariable Short id) {
        try {
            bookSevice.deactivateBook(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
