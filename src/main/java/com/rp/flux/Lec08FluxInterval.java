package com.rp.flux;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08FluxInterval {
    public static void main(String[] args) {

        System.out.println(Util.getThreadName());

        Flux.interval(Duration.ofSeconds(1)) // publishes items periodically
                .subscribe(Util.onNext());

        Util.sleepSeconds(10); // unless you block the main thread, you won't see as it is not blocking

    }

}
