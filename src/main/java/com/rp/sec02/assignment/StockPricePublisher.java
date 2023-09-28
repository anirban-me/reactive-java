package com.rp.sec02.assignment;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class StockPricePublisher {

    public static Flux<Integer> getPrice() {
        AtomicInteger atomicInteger = new AtomicInteger(100); // Starting point is 100
        return Flux.interval(Duration.ofSeconds(1)) // Every second
//                .log()
                .map(number -> atomicInteger.getAndAccumulate(
                        Util.faker().random().nextInt(-5, 5), // Get
                        Integer::sum // Accumulate.
                        // Sums it to previous sum -- starts at 100 and keeps adding the random number
                ));
    }
}
