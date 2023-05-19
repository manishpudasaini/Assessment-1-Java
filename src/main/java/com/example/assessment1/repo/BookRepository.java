package com.example.assessment1.repo;

import com.example.assessment1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Short> {
    List<Book> findByActiveTrue();
}
