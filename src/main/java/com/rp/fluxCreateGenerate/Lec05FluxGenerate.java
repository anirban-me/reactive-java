package com.rp.fluxCreateGenerate;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {
    public static void main(String[] args) {

        // creates new instance of synchronousSink
        Flux.generate(synchronousSink -> {
                    System.out.println("Emitting");
                    synchronousSink.next(Util.faker().country().name()); // synchronousSink will only emit 1 item, vs fluxSink sink can emit many
                    // generate() is responsible to invoke the Runnable again and again in a loop. complete() error() kills the loop.
                    // That's why generate() takes in synchronousSink
                    // Also, not need to worry about checking the cancelled subscription

//                    synchronousSink.complete();
                })
                .take(2) // removing this will make it an infinite loop
                .subscribe(Util.subscriber());
    }

}
