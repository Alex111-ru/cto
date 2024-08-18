package com.example.kinopoisk.controller;

import com.example.kinopoisk.model.Movie;
import com.example.kinopoisk.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void testGetMovieById() {
        Movie movie = new Movie();
        movie.setTitle("Inception");
        movie = movieRepository.save(movie);

        ResponseEntity<Movie> response = restTemplate.getForEntity("/movies/" + movie.getId(), Movie.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Inception", response.getBody().getTitle());
    }
}
