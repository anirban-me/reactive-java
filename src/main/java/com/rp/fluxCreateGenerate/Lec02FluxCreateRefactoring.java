package com.rp.fluxCreateGenerate;

import com.rp.util.Util;
import com.rp.fluxCreateGenerate.helper.NameProducerFluxSink;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefactoring {
    // Emit items using multiple threads - use flux sink

    public static void main(String[] args) {

        NameProducerFluxSink nameProducerFluxSink = new NameProducerFluxSink();

        Flux.create(nameProducerFluxSink) // publisher
                .subscribe(Util.subscriber());

        // Flux sink object is passed to create(..) method
        // Get the instance and do it outside the create(..) block

        Runnable runnable = nameProducerFluxSink::produce; // make it runnable

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start(); // and give it to the thread
            // 10 threads are invoking the produce()
        }

        Util.sleepSeconds(2);

    }

}
