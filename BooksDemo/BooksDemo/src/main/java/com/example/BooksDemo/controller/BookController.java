package com.example.BooksDemo.controller;

import com.example.BooksDemo.entity.Book;
import com.example.BooksDemo.responses.ApiResponse;
import com.example.BooksDemo.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Tag(name= "BookApi", description = "CRUD with Exception Handling")
public class BookController
{
    private final BookService service;

    public BookController(BookService service)
    {
        this.service = service;
    }
    @Operation(summary = "create Book")
    @PostMapping
    public ResponseEntity<ApiResponse<Book>> create(@RequestBody Book book)
    {
        ApiResponse<Book> response = new ApiResponse<>("Book created", service.save(book));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get Book by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> getById(@PathVariable Long id)
    {
        ApiResponse<Book> response = new ApiResponse<>("Book Found", service.getById(id));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get All Books")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Book>>> getAll()
    {
       ApiResponse<List<Book>> response = new ApiResponse<>("Book List", service.getAll());
       return ResponseEntity.ok(response);
    }

    @Operation(summary = "update Book")
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> update(
            @PathVariable Long id,
            @RequestBody Book book)
    {
        ApiResponse<Book> response = new ApiResponse<>("Book Updated", service.update(id, book));
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete Book")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> delete(
            @PathVariable Long id)
    {
        service.delete(id);

        ApiResponse<String> response = new ApiResponse<>("Book Deleted", "Deleted successfully");
        return ResponseEntity.ok(response);
    }


}
