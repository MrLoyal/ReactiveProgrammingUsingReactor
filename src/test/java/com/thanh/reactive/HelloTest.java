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
    void testMonoName(){
        StepVerifier.create(hello.name())
                .expectNext("Alex")
                .verifyComplete();

    }
}
