package com.example.ResponseEntity._5.controller;

import com.example.ResponseEntity._5.entity.Book;
import com.example.ResponseEntity._5.responses.ApiResponse;
import com.example.ResponseEntity._5.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/books")
public class BookController
{
    private final BookService service;

    public BookController(BookService service)
    {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Book>> addBook(@RequestBody Book book)
    {
        Book saved = service.saveBook(book);
        return ResponseEntity.ok(
                new ApiResponse<>("Book added successfully", LocalDateTime.now(), saved));

    }

    @GetMapping
    public ResponseEntity<ApiResponse<?>> getAllBooks()
    {
        return ResponseEntity.ok(
                new ApiResponse<>("Books fetched", LocalDateTime.now(), service.getAllBooks())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getBook(@PathVariable Long id)
    {
        return ResponseEntity.ok(
                new ApiResponse<>("Book fetched", LocalDateTime.now(), service.getBookById(id))
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateBook(@PathVariable Long id, @RequestBody Book book)
    {
        Book updatedBook = service.updateBook(id, book);

        if(updatedBook != null)
        {
            return ResponseEntity.ok(
                    new ApiResponse<>(
                            "Book Updated Successfully",
                            LocalDateTime.now(),
                            updatedBook
                    )
            );
        }

        return ResponseEntity.status(404).body(
                new ApiResponse<>(
                        "Book not found",
                        LocalDateTime.now(),
                        null
                )
        );
    }
}
