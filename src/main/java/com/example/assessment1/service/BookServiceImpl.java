package com.example.assessment1.service;

import com.example.assessment1.model.Book;
import com.example.assessment1.repo.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookSevice{
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getActiveBooks() {
        return bookRepository.findByActiveTrue();
    }

    @Override
    public Optional<Book> getBookById(Short id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Short id, Book book) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            book.setId(id);
            return bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Book having this " + id + " not found");
        }
    }

    @Override
    public void deleteBook(Short id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void activateBook(Short id) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setActive(true);
            bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Book having this " + id + " not found");
        }
    }

    @Override
    public void deactivateBook(Short id) {
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setActive(false);
            bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Book having this " + id + " not found");
        }
    }
}
