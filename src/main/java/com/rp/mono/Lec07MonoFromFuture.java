package com.rp.mono;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec07MonoFromFuture {

    public static void main(String[] args) {

        // Data is coming from async
        Mono.fromFuture(getName()).subscribe(Util.onNext());

        Util.sleepSeconds(1); // Have to block it to get data from completable future
        // else it runs off.
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
    }

}
