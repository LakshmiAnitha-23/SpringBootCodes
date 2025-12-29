package com.example.ResponseEntity._5.service;

import com.example.ResponseEntity._5.entity.Book;
import com.example.ResponseEntity._5.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService
{
    private final BookRepository repository;

    public BookService(BookRepository repository)
    {
        this.repository = repository;
    }
    public Book saveBook(Book book)
    {
        return repository.save(book);
    }

    public List<Book> getAllBooks()
    {
        return repository.findAll();
    }

    public Book getBookById(Long id)
    {
        return repository.findById(id).orElse(null);
    }
    public Book updateBook(Long id, Book newBook)
    {
        Book existingBook = repository.findById(id).orElse(null);

        if (existingBook != null)
        {
            existingBook.setTitle(newBook.getTitle());
            existingBook.setAuthor(newBook.getAuthor());
            existingBook.setPrice(newBook.getPrice());
            return repository.save(existingBook);
        }
        return null;
    }
}
