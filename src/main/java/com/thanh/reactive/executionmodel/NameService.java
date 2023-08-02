package com.thanh.reactive.executionmodel;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.List;

import static com.thanh.reactive.Utils.sleep;

public class NameService {


    List<String> nameList = List.of("Alex", "Bill", "Caroline");
    List<String> nameList2 = List.of("Daniel", "Emily", "Flora");

    public Flux<String> explorePublishOn(){
        Flux<String> flux1 = Flux.fromIterable(nameList)
                .map(s-> this.toUpper(s,600))
                .publishOn(Schedulers.parallel())
                .log();
        Flux<String> flux2 = Flux.fromIterable(nameList2)
                .publishOn(Schedulers.parallel())
                .map(s -> this.toUpper(s, 800))
                .log();
        return flux1.mergeWith(flux2);
    }

    public Flux<String> exploreSubscribeOn(){
        Flux<String> flux1 = Flux.fromIterable(nameList)
                .map(s-> this.toUpper(s,600))
                .subscribeOn(Schedulers.parallel())
                .log();
        Flux<String> flux2 = Flux.fromIterable(nameList2)
                .subscribeOn(Schedulers.parallel())
                .map(s -> this.toUpper(s, 800))
                .log();
        return flux1.mergeWith(flux2);
    }

    private String toUpper(String s, long delay){
        sleep(delay);
        return s.toUpperCase();
    }
}
