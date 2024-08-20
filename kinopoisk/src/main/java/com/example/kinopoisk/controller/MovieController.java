package com.example.kinopoisk.controller;



import com.example.kinopoisk.model.Movie;
import com.example.kinopoisk.model.Review;
import com.example.kinopoisk.service.MovieService;
import com.example.kinopoisk.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public Page<Movie> getMoviesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "title") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        return movieService.getMoviesPaginated(page, size, sortBy, sortOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable Long id) {
        return new ResponseEntity<>(movieService.getMovieById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(movieService.createMovie(movie), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return new ResponseEntity<>(movieService.updateMovie(id, movie), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public List<Movie> searchMovies(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer startYear,
            @RequestParam(required = false) Integer endYear,
            @RequestParam(required = false) Double minRating,
            @RequestParam(required = false) Double maxRating,
            @RequestParam(required = false) List<Long> genreIds) {
        // Передавать в качестве @RequestParam больше 2х аргументов плохая практика, лучше чере @ResponseBody
        // Большое количество else if - признак плохого кода. Тут нужен рефакторинг с использованием какого-нибудь шаблона проектирования
        // Также не предусмотрена ситуация если все фильтры переданы
        // Агрегацию поиска лучше вынести в отдельный сервис из которого уже вызывать movieService
        if (title != null) {
            return movieService.findMoviesByTitle(title);
        } else if (startYear != null && endYear != null) {
            return movieService.findMoviesByReleaseYearRange(startYear, endYear);
        } else if (minRating != null && maxRating != null) {
            return movieService.findMoviesByRatingRange(minRating, maxRating);
        } else if (genreIds != null) {
            return movieService.findMoviesByGenres(genreIds);
        } else {
            return movieService.getAllMovies();
        }
    }

    @PostMapping("/{movieId}/reviews")
    public ResponseEntity<Movie> addReviewToMovie(@PathVariable Long movieId, @RequestBody Review review) {
        return new ResponseEntity<>(movieService.addReviewToMovie(movieId, review), HttpStatus.CREATED);
    }

    @GetMapping("/{movieId}/reviews")
    public ResponseEntity<List<Review>> getReviewsByMovie(@PathVariable Long movieId) {
        return new ResponseEntity<>(reviewService.getReviewsByMovie(movieId), HttpStatus.OK);
    }
}