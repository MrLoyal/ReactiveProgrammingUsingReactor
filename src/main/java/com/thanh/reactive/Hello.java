package com.thanh.reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

public class Hello {
    public void hello(){
        Mono<String> mono = Mono.just("Hello");
        mono.subscribe();
    }

    public Flux<String> names(){
        return Flux.fromIterable(Arrays.asList("Adam", "Bob", "Chloe", "Dan", "Emily"));
    }

    public Mono<String> name(){
        return Mono.just("Alex");
    }
}
