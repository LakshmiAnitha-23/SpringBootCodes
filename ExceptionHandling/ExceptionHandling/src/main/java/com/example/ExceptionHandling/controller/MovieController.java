package com.example.ExceptionHandling.controller;

import com.example.ExceptionHandling.entity.Movie;
import com.example.ExceptionHandling.responses.ApiResponse;
import com.example.ExceptionHandling.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController
{
    private final MovieService movieService;

    public MovieController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Movie>> addMovie(@RequestBody Movie movie)
    {
        return ResponseEntity.ok(
                new ApiResponse<>(
                        "movie added successfuly",
                        movieService.saveMovie(movie),
                        LocalDateTime.now())
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Movie>>> getAllMovies()
    {
        return ResponseEntity.ok(
                new ApiResponse<>("All movies fetched",
                        movieService.getAllMovies(),
                        LocalDateTime.now())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Movie>> getMovie(@PathVariable Long id)
    {
        return ResponseEntity.ok(
                new ApiResponse<>("Movie found",
                        movieService.getMovieById(id),
                        LocalDateTime.now())
        );
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<ApiResponse<List<Movie>>> getByRating(@PathVariable double rating)
    {
        return ResponseEntity.ok(
                new ApiResponse<>("Movies with rating greater than " + rating,
                        movieService.getByRating(rating),
                        LocalDateTime.now())
        );
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<ApiResponse<List<Movie>>> getByGenre(@PathVariable String genre)
    {
        return ResponseEntity.ok(
                new ApiResponse<>("movies by genre",
                        movieService.getByGenre(genre),
                        LocalDateTime.now())
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteMovie(@PathVariable Long id)
    {
        movieService.deleteMovie(id);
        return ResponseEntity.ok(
                new ApiResponse<>("Movies deleted Successfully",
                        "Deleted ID: " + id,
                        LocalDateTime.now())
        );
    }
}
