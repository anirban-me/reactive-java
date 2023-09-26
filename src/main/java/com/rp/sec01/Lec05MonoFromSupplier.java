package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {

        // use just only when you have data already
        // Mono<String> mono = Mono.just(getName());

        Supplier<String> stringSupplier = Lec05MonoFromSupplier::getName;
        // Stops from generating unless subscriber demands
        Mono<String> mono = Mono.fromSupplier(stringSupplier);
        mono.subscribe(
                Util.onNext()
        );

        // Same as supplier
        Callable<String> stringCallable = Lec05MonoFromSupplier::getName;
        Mono.fromCallable(stringCallable)
                .subscribe(
                        Util.onNext()
                );
    }

    private static String getName() {
        //  Data is to be calculated
        System.out.println("Generating name..");
        return Util.faker().name().fullName();
    }

}
