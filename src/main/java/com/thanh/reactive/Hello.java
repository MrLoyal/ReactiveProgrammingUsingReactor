package com.thanh.reactive;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Hello {

    private static final Logger logger = LoggerFactory.getLogger(Hello.class);

    public void hello() {
        Mono<String> mono = Mono.just("Hello").log();
        mono.subscribe();
    }

    public Flux<String> names() {
        return Flux.fromIterable(Arrays.asList("Adam", "Bob", "Chloe", "Dan", "Emily"));
    }

    public Mono<String> name() {
        return Mono.just("Alex");
    }

    public Flux<String> splitNames(String s) {
        var charArrays = s.split("");
        return Flux.fromArray(charArrays);
    }

    public Flux<String> splitNamesWithDelay(String name) {
        Random random = new Random();
        int rand = random.nextInt(1000);
        var charArrays = name.split("");
        return Flux.fromArray(charArrays)
                .delayElements(Duration.ofMillis(rand));
    }

    public Mono<List<String>> monoNameAsList(String name) {
        String[] charArray = name.split("");
        List<String> list = List.of(charArray);
        return Mono.just(list);
    }


    public Flux<String> hiConcat() {
        Flux<String> abc = Flux.just("A", "B", "C");
        Flux<String> def = Flux.just("D", "E", "F");
        abc.concatWith(def);
        return Flux.concat(abc, def);
    }

    public Flux<String> hiConcatWith() {
        Mono<String> a = Mono.just("A");
        Mono<String> b = Mono.just("B");

        return a.concatWith(b);
    }

    public Flux<String> hiMerge() {
        Flux<String> abc = Flux.just("A", "B", "C")
                .delayElements(Duration.ofMillis(100));
        Flux<String> def = Flux.just("D", "E", "F")
                .delayElements(Duration.ofMillis(130));
        return Flux.merge(abc, def);
    }

    public Flux<String> hiMergeWith() {
        Flux<String> abc = Flux.just("A", "B", "C")
                .delayElements(Duration.ofMillis(100));
        Flux<String> def = Flux.just("D", "E")
                .delayElements(Duration.ofMillis(130));
        return abc.mergeWith(def);
    }

    public Flux<String> hiMergeSequential() {
        Flux<String> ab = Flux.just("A", "B")
                .delayElements(Duration.ofMillis(100));
        Flux<String> cd = Flux.just("C", "D")
                .delayElements(Duration.ofMillis(130));
        Flux<String> ef = Flux.just("E", "F")
                .delayElements(Duration.ofMillis(135));
        return Flux.mergeSequential(ab, cd, ef);
    }

    public Flux<String> hiZip() {
        Flux<String> abc = Flux.just("A", "B", "C")
                .delayElements(Duration.ofMillis(100));
        Flux<String> def = Flux.just("D", "E", "F")
                .delayElements(Duration.ofMillis(130));

        return Flux.zip(abc, def, (first, second) -> first + "-" + second);
    }

    public Flux<String> hiError() {
        return Flux.just("A", "B")
                .concatWith(Flux.error(new RuntimeException("An error occurred")))
                .concatWith(Flux.just("C"));
    }
}
