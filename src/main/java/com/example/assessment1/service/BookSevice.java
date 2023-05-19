package com.example.assessment1.service;

import com.example.assessment1.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookSevice {
    List<Book> getAllBooks();
    List<Book> getActiveBooks();
    Optional<Book> getBookById(Short id);
    Book addBook(Book book);
    Book updateBook(Short id, Book book);
    void deleteBook(Short id);
    void activateBook(Short id);
    void deactivateBook(Short id);

}
