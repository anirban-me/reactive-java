package com.rp.fluxCreateGenerate;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class Lec06FluxGenerateAssignment {
    public static void main(String[] args) {

        // generate till India is received
        Flux.generate(synchronousSink -> {
                    String country = Util.faker().country().name();
                    System.out.println("Emitting " + country);
                    synchronousSink.next(country);
                    if (country.equalsIgnoreCase("India"))
                        synchronousSink.complete();
                })
                .subscribe(Util.subscriber());
    }
}
