package com.thanh.reactive.movie.service;

import com.thanh.reactive.movie.domain.MovieInfo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class MovieInfoService {

    public Flux<MovieInfo> findAll(){
        return Flux.just(
                new MovieInfo(1001L, "Great film one", 1998, List.of("Thanh", "Loyal")),
                new MovieInfo(1002L, "Lorem film two", 2020, List.of("Simson", "Fault"))
        );
    }

    public Mono<MovieInfo> findById(long id){
        return Mono.just(new MovieInfo(1001L, "Great film one", 1998, List.of("Thanh", "Loyal")));
    }

}
