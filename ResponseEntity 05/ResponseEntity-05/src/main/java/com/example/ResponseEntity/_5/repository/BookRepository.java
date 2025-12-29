package com.example.ResponseEntity._5.repository;

import com.example.ResponseEntity._5.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>
{
}
