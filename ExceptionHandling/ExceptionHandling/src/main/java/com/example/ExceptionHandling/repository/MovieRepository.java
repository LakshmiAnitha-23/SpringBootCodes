package com.example.ExceptionHandling.repository;

import com.example.ExceptionHandling.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long>
{
    List<Movie> findByTitle(String title);
    List<Movie> findByGenre(String genre);
    List<Movie> findByRatingGreaterThan(double rating);
}
