package com.rp.courseutil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import static com.rp.courseutil.Util.getThreadName;

public class DefaultSubscriber implements Subscriber<Object> {

    private String name = "";

    public DefaultSubscriber(String name) {
        this.name = name + " - ";
    }

    public DefaultSubscriber() {
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE); //unbounded -- give me all
    }

    @Override
    public void onNext(Object o) {
        System.out.println(name + "Received : " + o + " at " + getThreadName());
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(name + "ERROR : " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name + "Completed");
    }
}
