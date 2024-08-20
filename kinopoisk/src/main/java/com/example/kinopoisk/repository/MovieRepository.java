package com.example.kinopoisk.repository;


import com.example.kinopoisk.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // Такие комментарии не нужны, по названию и так понятно
    // Поиск фильмов по названию, игнорируя регистр
    List<Movie> findByTitleContainingIgnoreCase(String title);

    // Поиск фильмов по диапазону года выпуска
    List<Movie> findByReleaseYearBetween(Integer startYear, Integer endYear);

    // Поиск фильмов по диапазону средней оценки
    List<Movie> findByAverageRatingBetween(Double minRating, Double maxRating);

    // Поиск фильмов по списку жанров
    @Query("SELECT m FROM Movie m JOIN m.genres g WHERE g.id IN :genreIds GROUP BY m.id HAVING COUNT(g.id) = :genreCount")
    List<Movie> findByGenresIn(@Param("genreIds") List<Long> genreIds, @Param("genreCount") int genreCount);
}
