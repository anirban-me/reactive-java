package com.rp.fluxCreateGenerate;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class Lec07FluxGenerateCounter {
    public static void main(String[] args) {

        // Maximum emit 10 countries -- can also use take(..)
        Flux.generate(
                        () -> 1, // counter (state param)
                        (counter, synchronousSink) -> {
                            String country = Util.faker().country().name();
                            synchronousSink.next(country);

                            if (counter >= 10 || country.equalsIgnoreCase("India"))
                                synchronousSink.complete();
                            return counter + 1; // output for previous run, is input for the next
                        }
                )
//                .take(10)
                .subscribe(Util.subscriber());
    }
}
