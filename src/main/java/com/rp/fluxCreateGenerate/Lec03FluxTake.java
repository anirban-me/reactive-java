package com.rp.fluxCreateGenerate;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {
    public static void main(String[] args) {
        // map
        // filter
        Flux.range(1, 10)
                .log()
                .take(3) // cancels subscription -- and complete(): 3 items
                .log()
                .subscribe(Util.subscriber());

    }
}
