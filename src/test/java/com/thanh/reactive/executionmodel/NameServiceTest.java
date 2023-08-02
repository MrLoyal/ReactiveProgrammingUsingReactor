package com.thanh.reactive.executionmodel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class NameServiceTest {

    NameService nameService;
    @BeforeEach
    void setup(){
        nameService = new NameService();
    }

    @Test
    void explorePublishOn() {

        nameService.explorePublishOn()
                .as(StepVerifier::create)
                .expectNextCount(6)
                .verifyComplete();

    }
}
