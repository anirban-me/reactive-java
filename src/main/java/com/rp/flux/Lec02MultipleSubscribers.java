package com.rp.flux;

import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {
    public static void main(String[] args) {

        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);
        Flux<Integer> evenFlux = integerFlux.filter(i -> i % 2 == 0); // also applicable for mono

        integerFlux.subscribe(i -> System.out.println("Sub Integer : " + i));
        evenFlux.subscribe(i -> System.out.println("Sub Even : " + i));


    }

}
