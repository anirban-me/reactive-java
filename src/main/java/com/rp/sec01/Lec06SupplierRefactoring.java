package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {

    public static void main(String[] args) {


        getName(1); // will only build the pipeline

        // subscribe -- this is blocked for 3s sleep time
        getName(2).subscribe(Util.onNext());


        String name = getName(3)
                .subscribeOn(Schedulers.boundedElastic()) // makes completely async - a different thread
                .block(); // to get the name, you need to block the main thread
        System.out.println(name);

        getName(4);
    }

    private static Mono<String> getName(int count) {
        System.out.println("entered getName method " + count);

        // This builds the pipeline, but only executes when subscriber demands
        // Building pipeline is easy, execution takes time
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name.. " + count);
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }

}
