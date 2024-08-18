package com.example.kinopoisk.repository;


import com.example.kinopoisk.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    // Поиск рецензий по идентификатору фильма
    List<Review> findByMovieId(Long movieId);

    // Поиск рецензий по идентификатору критика
    List<Review> findByCriticId(Long criticId);
}