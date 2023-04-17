package com.thanh.reactive.movie.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    private MovieService movieService;
    @BeforeEach
    public void setup(){
        MovieInfoService movieInfoService = new MovieInfoService();
        ReviewService reviewService = new ReviewService();
        movieService = new MovieService(movieInfoService, reviewService);
    }

    @Test
    void findAll() {

        movieService.findAll()
                .log()
                .as(StepVerifier::create)
                .assertNext(movie -> {
                    assertEquals("Great film one", movie.getMovieInfo().getName());
                    assertEquals(2, movie.getReviewList().size());
                })
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void testFindById(){
        movieService.findById(1L)
                .log()
                .as(StepVerifier::create)
                .assertNext(m -> {
                    assertNotNull(m.getMovieInfo());
                    assertNotNull(m.getMovieInfo().getName());
                })
                .verifyComplete();
    }
}
