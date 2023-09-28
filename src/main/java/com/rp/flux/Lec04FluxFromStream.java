package com.rp.flux;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {

    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

        // Stream cannot be reused after you apply the operation
        // System.out.println("Stream print");
        // stream.forEach(System.out::println); // stream closed

        System.out.println("Flux print 1");
        Flux<Integer> integerFlux = Flux.fromStream(list::stream); // convert list again to stream - build pipeline
        // Flux<Integer> integerFlux = Flux.fromStream(stream); // stream once used, cannot be opened again

        integerFlux
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

        // Won't work for line 22
        System.out.println("Flux print 2");
        integerFlux
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );


    }

}
