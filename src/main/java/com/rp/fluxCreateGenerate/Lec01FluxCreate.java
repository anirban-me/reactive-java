package com.rp.fluxCreateGenerate;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {

    public static void main(String[] args) {

        Flux.create(fluxSink -> { // this publisher can emit anything. Here emit countries till "india"
                    // flux sink is the sink where you push the data to be emitted
                    String country;
                    do {
                        country = Util.faker().country().name();
                        fluxSink.next(country);
                    } while (!country.equalsIgnoreCase("India"));
                    fluxSink.complete();
                })
                .subscribe(Util.subscriber());


    }

}
