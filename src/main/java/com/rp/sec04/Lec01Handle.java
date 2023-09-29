package com.rp.sec04;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class Lec01Handle {
    public static void main(String[] args) {

        Flux.range(1, 20)
                .handle((number, synchronousSink) -> { // synchronousSink can only next()/add one item
                    if (number == 7) {
                        synchronousSink.complete();
                    } else {
                        synchronousSink.next(number);
                        // cannot do another emit/next() here
                    }
                })
                .subscribe(Util.subscriber());
    }
}
