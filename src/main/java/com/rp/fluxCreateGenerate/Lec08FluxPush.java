package com.rp.fluxCreateGenerate;

import com.rp.util.Util;
import com.rp.fluxCreateGenerate.helper.NameProducerFluxSink;
import reactor.core.publisher.Flux;

public class Lec08FluxPush {
    public static void main(String[] args) {
        // Not thread safe. Values might be missing
        NameProducerFluxSink nameProducerFluxSink = new NameProducerFluxSink();

        Flux.create(nameProducerFluxSink)
                .subscribe(Util.subscriber());

        Runnable runnable = nameProducerFluxSink::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);


    }


}
