package com.rp.sec04;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class Lec02HandleAssignment {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name())) // infinite generation
                .map(Object::toString) // Because generate emits Object
                .handle((theCountry, synchronousSink) -> {
                    synchronousSink.next(theCountry); // adding only once (not inside a loop)
                    if (theCountry.equalsIgnoreCase("India"))
                        synchronousSink.complete();
                })
                .subscribe(Util.subscriber());

    }

}
