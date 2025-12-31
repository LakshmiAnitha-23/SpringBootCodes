package com.example.BooksDemo.service;

import com.example.BooksDemo.entity.Book;
import com.example.BooksDemo.exception.BookNotFoundException;
import com.example.BooksDemo.repository.BookRepository;
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

    public Book save(Book book)
    {
        return repository.save(book);
    }

    public Book getById(Long id)
    {
        return repository.findById(id)
                .orElseThrow(() ->
                        new BookNotFoundException("book not found with id: " + id));
    }

    public List<Book> getAll()
    {
        return repository.findAll();
    }

    public Book update(Long id, Book book)
    {
        Book existing = getById(id);
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setPrice(book.getPrice());
        return repository.save(existing);
    }

    public void delete(Long id)
    {
        Book book = getById(id);
        repository.delete(book);
    }

}
