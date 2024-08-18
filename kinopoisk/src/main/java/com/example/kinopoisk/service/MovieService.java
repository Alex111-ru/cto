package com.example.kinopoisk.service;


import com.example.kinopoisk.model.Movie;
import com.example.kinopoisk.model.Review;
import com.example.kinopoisk.repository.MovieRepository;
import com.example.kinopoisk.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Page<Movie> getMoviesPaginated(int page, int size, String sortBy, String sortOrder) {
        Sort sort = Sort.by(sortBy);
        sort = "desc".equalsIgnoreCase(sortOrder) ? sort.descending() : sort.ascending();
        return movieRepository.findAll(PageRequest.of(page, size, sort));
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie movie) {
        movie.setId(id);
        return movieRepository.save(movie);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    public List<Movie> findMoviesByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> findMoviesByReleaseYearRange(Integer startYear, Integer endYear) {
        return movieRepository.findByReleaseYearBetween(startYear, endYear);
    }

    public List<Movie> findMoviesByRatingRange(Double minRating, Double maxRating) {
        return movieRepository.findByAverageRatingBetween(minRating, maxRating);
    }

    public List<Movie> findMoviesByGenres(List<Long> genreIds) {
        return movieRepository.findByGenresIn(genreIds, genreIds.size());
    }

    public Movie addReviewToMovie(Long movieId, Review review) {
        Movie movie = movieRepository.findById(movieId).orElseThrow();
        review.setMovie(movie);
        reviewRepository.save(review);

        updateMovieRating(movie);
        return movieRepository.save(movie);
    }

    private void updateMovieRating(Movie movie) {
        List<Review> reviews = reviewRepository.findByMovieId(movie.getId());
        if (!reviews.isEmpty()) {
            double average = reviews.stream()
                    .mapToInt(Review::getRating)
                    .average()
                    .orElse(5.0);
            movie.setAverageRating(average);
        }
    }
}