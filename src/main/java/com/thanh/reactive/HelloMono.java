package com.thanh.reactive;

import reactor.core.publisher.Mono;

import java.util.function.BiConsumer;

public class HelloMono {

    public Mono<Object> exploreOnErrorContinue(){
        return Mono.error(new IllegalStateException("Hi"))
                .onErrorContinue(new BiConsumer<Throwable, Object>() {
                    @Override
                    public void accept(Throwable throwable, Object s) {
                        System.out.println("onErrorContinue:");
                        System.out.println("  throwable: " + throwable.getClass().getName());
                        System.out.println("  object: " + s);
                    }
                });
    }

}
