package com.example.kinopoisk.service;

import com.example.kinopoisk.model.Movie;
import com.example.kinopoisk.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MovieServiceTests {
    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    // Можно вместо этого над классом навесить @ExtendWith(MockitoExtension.class)
    public MovieServiceTests() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMovieById() {
        Movie movie = new Movie();
        movie.setId(1L);
        when(movieRepository.findById(1L)).thenReturn(Optional.of(movie));

        Optional<Movie> result = movieService.getMovieById(1L);
        assertEquals(1L, result.get().getId());
    }
}
