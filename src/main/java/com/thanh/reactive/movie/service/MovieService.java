package com.thanh.reactive.movie.service;

import com.thanh.reactive.movie.domain.Movie;
import com.thanh.reactive.movie.domain.MovieInfo;
import com.thanh.reactive.movie.domain.Review;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class MovieService {

    private final MovieInfoService movieInfoService;
    private final ReviewService reviewService;

    public MovieService(MovieInfoService movieInfoService, ReviewService reviewService) {
        this.movieInfoService = movieInfoService;
        this.reviewService = reviewService;
    }

    public Flux<Movie> findAll(){
        return movieInfoService.findAll()
                .flatMap(
                        movieInfo -> {
                            Mono<List<Review>> reviewsMono = reviewService.findAllByMovieInfoId(movieInfo.getId())
                                    .collectList();
                            return reviewsMono.map(
                                    reviewList -> {
                                        Movie movie = new Movie();
                                        movie.setMovieInfo(movieInfo);
                                        movie.setReviewList(reviewList);
                                        return movie;
                                    }
                            );
                        }
                );
    }

    public Mono<Movie> findById(long movieId){
        Mono<MovieInfo> movieInfoMono = movieInfoService.findById(movieId);
        Mono<List<Review>> reviewListMono = reviewService.findAllByMovieInfoId(movieId).collectList();

        return movieInfoMono.zipWith(reviewListMono, (movieInfo, reviewList) -> {
            Movie movie = new Movie();
            movie.setId(movieId);
            movie.setMovieInfo(movieInfo);
            movie.setReviewList(reviewList);
            return movie;
        });

    }
}
