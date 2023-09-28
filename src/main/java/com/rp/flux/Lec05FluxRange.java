package com.rp.flux;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {
    public static void main(String[] args) {

        Flux.range(3, 10)
                //.log() // used for debugging -- shows output of Flux.range stepwise
                .map(i -> Util.faker().name().fullName())
                //.log() // shows output of map(...) stepwise
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );
    }

    // request(unbounded) -> Give me all the data you have (see print statement for log)
}
