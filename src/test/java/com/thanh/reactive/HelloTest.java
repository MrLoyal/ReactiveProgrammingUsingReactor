package com.thanh.reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;
import java.util.function.Function;

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
        // flux.subscribe();
        StepVerifier.create(flux)
                //.expectNext("a")
                .expectNextCount(14)
                .verifyComplete();
    }

    @Test
    void hello() {
        hello.hello();
    }

    @Test
    public void testConcatMap() {
        Flux<String> names = Flux.fromArray(new String[]{"Alex", "Ben"});
        // Flux<String> cat = names.concatMap(s -> hello.splitNamesWithDelay(s)).log();
        Flux<String> cat = names.flatMap(s -> hello.splitNamesWithDelay(s)).log();

        StepVerifier.create(cat)
                .expectNext("A")
                .expectNext("l")
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    public void testMonoFlatMap() {
        String name = "Emily";
        Mono<List<String>> monoList = hello.monoNameAsList(name);
        Mono<String> mapped = monoList.flatMap(l -> {
                    return Mono.just("Size=" + l.size() + "");
                })
                .log();

        StepVerifier.create(mapped)
                .expectNext("Size=5")
                .verifyComplete();

    }

    @Test
    public void testMonoFlatMap2() {
        String name = "Emily";

        Mono<List<String>> m = Mono.just(name)
                .flatMap(s -> {
                    String[] charArr = name.split("");
                    List<String> list = List.of(charArr);
                    return Mono.just(list);
                })
                .log();
        StepVerifier.create(m)
                .expectNext(List.of("E", "m", "i", "l", "y"))
                .verifyComplete();
    }

    @Test
    public void testFlatMapMany() {
        Flux<String> flux = Mono.just("Alex")
                .flatMapMany(s -> hello.splitNames(s))
                .log();

        StepVerifier.create(flux)
                .expectNext("A", "l", "e", "x")
                .verifyComplete();
    }

    @Test
    public void testTransform() {
        Function<Flux<String>, Flux<String>> transformer = f -> f.map(String::toUpperCase);

        Flux<String> names = Flux.fromIterable(List.of("Alex", "Bob"));
        Flux<String> flux = names.transform(transformer)
                .log();
        StepVerifier.create(flux).expectNextCount(2)
                .verifyComplete();
    }

    @Test
    public void testDefault() {
        Flux.fromIterable(List.of("Alice", "Bob"))
                .filter(s -> s.length() > 5)
                .defaultIfEmpty("Carlos")
                .log()
                .as(StepVerifier::create)
                .expectNext("Carlos")
                .verifyComplete();
    }

    @Test
    public void testSwitchIfEmpty() {

        Function<Flux<String>, Flux<String>> transformer = stringFlux -> {
            // Alice, Bob
            // --> A,l,i,c,e,B,o,b
            return stringFlux.flatMap(name -> hello.splitNames(name));
        };

        Flux<String> defaultFlux = Flux.just("Daniel")
                .transform(transformer)
                .log();

        Flux.fromIterable(List.of("Alice", "Bob"))
                .filter(s -> s.length() > 5)
                .switchIfEmpty(defaultFlux)
                .log()
                .as(StepVerifier::create)
                .expectNext("D")
                .expectNextCount(5)
                .verifyComplete();
    }


    @Test
    public void testConcat() {
        hello.hiConcat()
                .log()
                .as(StepVerifier::create)
                .expectNext("A", "B", "C", "D", "E", "F")
                .verifyComplete();
    }

    @Test
    public void testMerge(){
        hello.hiMerge().log()
                .as(StepVerifier::create)
                .expectNext("A")
                .expectNextCount(5)
                .verifyComplete();
    }


    @Test
    public void testFluxMergeWith(){
        hello.hiMergeWith().log()
                .as(StepVerifier::create)
                .expectNext("A")
                .expectNextCount(4)
                .verifyComplete();
    }

    @Test
    public void testFluxMergeSequential(){
        hello.hiMergeSequential()
                .log()
                .as(StepVerifier::create)
                .expectNext("A")
                .expectNextCount(5)
                .verifyComplete();
    }


    @Test
    public void testZip(){
        hello.hiZip()
                .log()
                .as(StepVerifier::create)
                .expectNext("A-D")
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    public void testError(){
        hello.hiError()
                .log()
                .as(StepVerifier::create)
                .expectNext("A", "B")
                .expectError()
                .verify();
    }
}
