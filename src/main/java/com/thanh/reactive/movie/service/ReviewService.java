package com.thanh.reactive.movie.service;

import com.thanh.reactive.movie.domain.Review;
import reactor.core.publisher.Flux;

public class ReviewService {
    public Flux<Review> findAllByMovieInfoId(long movieInfoId){
        return Flux.just(
                new Review(11L, "Good", 9.9f),
                new Review(12L, "Quite Good", 9.0f)
        );
    }
}
