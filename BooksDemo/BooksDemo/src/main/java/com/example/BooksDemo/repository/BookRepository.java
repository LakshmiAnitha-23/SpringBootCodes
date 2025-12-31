package com.example.BooksDemo.repository;

import com.example.BooksDemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long>
{
}
