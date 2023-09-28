package com.rp.sec02;

import com.rp.courseutil.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {

    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>(); // holds the "subscription" object
        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received Sub : " + subscription);
                        atomicReference.set(subscription);
                        // You can request here itself. That's how the reactor does it
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext : " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError : " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });


        // Unless the subscriber requests the publisher, you won't get items
        // For previous examples, things were handled by the reactor
        // With this custom implementation, we need to hande it

        Util.sleepSeconds(3);
        atomicReference.get().request(3); // although there are 20 items, request is for only 3
        // the normal subscriber subscribes for all (unbounded)

        Util.sleepSeconds(3);
        atomicReference.get().request(3);

        Util.sleepSeconds(3);
        System.out.println("Going to cancel");
        atomicReference.get().cancel();
        System.out.println("Cancelled");

        Util.sleepSeconds(3);
        atomicReference.get().request(4); // nothing happens as subscription is cancelled
        Util.sleepSeconds(3);


    }


}
