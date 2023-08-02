package com.thanh.reactive.movie.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.retry.Retry;
import reactor.util.retry.RetryBackoffSpec;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    MovieInfoService movieInfoService ;

    @Mock
    ReviewService reviewService;

    @InjectMocks
    private MovieService movieService;


    @Test
    void findAll() {
        when(reviewService.findAllByMovieInfoId(anyLong()))
                .thenCallRealMethod();

        when(movieInfoService.findAll()).thenCallRealMethod();

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

        when(reviewService.findAllByMovieInfoId(anyLong()))
                .thenCallRealMethod();

        when(movieInfoService.findById(anyLong())).thenCallRealMethod();

        movieService.findById(1L)
                .log()
                .as(StepVerifier::create)
                .assertNext(m -> {
                    assertNotNull(m.getMovieInfo());
                    assertNotNull(m.getMovieInfo().getName());
                })
                .verifyComplete();
    }


    @Test
    void testRetry1(){

        Flux.just("A", "B")
                .concatWith(Flux.error(new RuntimeException("Coca cola")))
                .concatWith(Flux.just("C"))
                .retry(1)
                .as(StepVerifier::create)
                .expectNext("A", "B")
                .expectNext("A", "B")
                .verifyError();
    }

    @Test
    void testRetry2(){

        RetryBackoffSpec backoff = Retry.backoff(2, Duration.ofMillis(50));

        Flux.just("A", "B")
                .concatWith(Flux.error(new RuntimeException("Coca cola")))
                .concatWith(Flux.just("C"))
                .retryWhen(backoff)
                // .retry(2)
                .log()
                .subscribe();
    }

    @Test
    void repeatTest(){
        Flux.just("A", "B")
                .log()
                .repeat()
                .as(StepVerifier::create)
                .expectNextCount(3)
                .thenCancel()
                .verify();
    }
}
