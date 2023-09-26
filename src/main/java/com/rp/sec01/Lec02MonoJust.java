package com.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec02MonoJust {
    public static void main(String[] args) {

        // publisher
        Mono<Integer> mono = Mono.just(1);

        System.out.println(mono);

        // nothing happens until you subscribe
        // Give me the data that you've
        mono.subscribe(i -> System.out.println("Received : " + i));

    }
}
