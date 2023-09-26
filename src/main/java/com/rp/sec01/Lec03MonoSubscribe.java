package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {
        int div = 2;

        // publisher
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(len -> len / div);

        // do task as per what happens at the publisher
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );


    }

}
