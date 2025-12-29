package com.example.ExceptionHandling.service;

import com.example.ExceptionHandling.entity.Movie;
import com.example.ExceptionHandling.exception.MovieNotFoundException;
import com.example.ExceptionHandling.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService
{
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository)
    {
        this.movieRepository = movieRepository;
    }
    public Movie saveMovie(Movie movie)
    {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies()
    {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id)
    {
        return movieRepository.findById(id)
                .orElseThrow(() ->
                        new MovieNotFoundException("movie not found with id: " + id));
    }
    public List<Movie> getByGenre(String genre)
    {
        return movieRepository.findByGenre(genre);
    }

    public List<Movie> getByRating(double rating)
    {
        return movieRepository.findByRatingGreaterThan(rating);
    }

    public void deleteMovie(Long id)
    {
        if(!movieRepository.existsById(id))
        {
            throw new MovieNotFoundException("movie not found with id: " + id);
        }
        movieRepository.deleteById(id);
    }
}
