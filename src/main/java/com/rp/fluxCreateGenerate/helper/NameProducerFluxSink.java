package com.rp.fluxCreateGenerate.helper;

import com.rp.util.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducerFluxSink implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }

    public void produce() {
        this.fluxSink.next(Util.faker().name().fullName());
    }

}
