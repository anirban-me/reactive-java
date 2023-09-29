package com.rp.fluxCreateGenerate;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {
    public static void main(String[] args) {

        // Here you only get one instance of fluxSInk
        Flux.create(fluxSink -> {
                    String country;
                    do {
                        country = Util.faker().country().name();
                        System.out.println("Emitting : " + country);
                        // If you don't check isCancelled(..), it keeps emitting even after take(..)
                        // On adding, it will always emit 3
                        fluxSink.next(country);
                    } while (!country.equalsIgnoreCase("India") && !fluxSink.isCancelled());
                    fluxSink.complete();
                })
                .take(3)
                .subscribe(Util.subscriber());
    }

}
