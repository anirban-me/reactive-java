package com.rp.flux;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {
    public static void main(String[] args) {
        System.out.println("Mono to Flux");
        Mono<String> mono = Mono.just("ABC");
        Flux<String> fluxFromMono = Flux.from(mono);
        fluxFromMono.subscribe(Util.onNext());

        System.out.println("\nFlux to Mono");
        Flux.range(1, 10)
                .filter(i -> i > 3)
                .next() // 4
                // if you place the filter here instead of above next(), it won't work -- input of pipeline will be 1
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
