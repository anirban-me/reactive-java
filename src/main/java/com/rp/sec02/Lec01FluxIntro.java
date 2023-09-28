package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {

    public static void main(String[] args) {

        Flux<Object> flux = Flux.just(1, 'X', 3, "abc", Util.faker().name().fullName(), new Object());

        flux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());


    }

}
