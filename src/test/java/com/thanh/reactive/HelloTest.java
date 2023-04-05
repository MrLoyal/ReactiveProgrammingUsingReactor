package com.thanh.reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class HelloTest {

    Hello hello = new Hello();

    @Test
    void testName() {
        Flux<String> namesFlux = hello.names();
        StepVerifier.create(namesFlux)
                .expectNext("Adam", "Bob", "Chloe", "Dan", "Emily")
                .expectComplete();
    }

    @Test
    void testMonoName() {
        StepVerifier.create(hello.name())
                .expectNext("Alex")
                .verifyComplete();
    }

    @Test
    void testFlatMap() {
        var namesFlux = hello.names();

        var names = namesFlux.filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .flatMap(s -> hello.splitNames(s))
                .log();

        StepVerifier.create(names)
                .expectNext("A")
                .expectNextCount(8)
                .expectComplete();

    }

    @Test
    void testDelayed() {
        var names = hello.names();

        var flux = names.filter(s -> s.length() > 3)
                .flatMap(s -> hello.splitNamesWithDelay(s));
        //flux.subscribe();
        StepVerifier.create(flux)
                //.expectNext("a")
                .expectNextCount(14)
                .verifyComplete();
    }

    @Test
    void hello(){
        hello.hello();
    }
}
