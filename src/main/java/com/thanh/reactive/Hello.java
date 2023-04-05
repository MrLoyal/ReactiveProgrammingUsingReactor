package com.thanh.reactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

public class Hello {

    private static final Logger logger = LoggerFactory.getLogger(Hello.class);

    public void hello(){
        Mono<String> mono = Mono.just("Hello").log();
        mono.subscribe();
    }

    public Flux<String> names(){
        return Flux.fromIterable(Arrays.asList("Adam", "Bob", "Chloe", "Dan", "Emily"));
    }

    public Mono<String> name(){
        return Mono.just("Alex");
    }

    public Flux<String> splitNames(String s){
        var charArrays = s.split("");
        return Flux.fromArray(charArrays);
    }

    public Flux<String> splitNamesWithDelay(String name){
        Random random = new Random();
        int rand = 999; // = random.nextInt(1000);
        var charArrays = name.split("");
        return Flux.fromArray(charArrays)
                .delayElements(Duration.ofMillis(rand))
                .log();
    }
}
