package com.rp.sec02;

import com.rp.sec02.assignment.StockPricePublisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class Lec10StockPriceAssignment {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1); // Waiting for 1 thread
        /*
         * Working of CountDownLatch:
         * When we create an object of CountDownLatch, we specify the number of threads it should wait for,
         * all such (child) thread(s) are required to do count down by calling CountDownLatch.countDown() once they are completed or ready to the job.
         * As soon as count reaches zero, the waiting task starts running.
         *
         * */

        StockPricePublisher.getPrice() // publisher - keeps giving the updated price
                .subscribeWith(new Subscriber<Integer>() {
                    private Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        subscription.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer price) {
                        System.out.println(LocalDateTime.now() + " : Price : " + price);
                        if (price > 110 || price < 90) {
                            this.subscription.cancel();
                            latch.countDown();
                        }
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        latch.countDown();
                    }

                    @Override
                    public void onComplete() {
                        latch.countDown();
                    }
                });

        latch.await(); // the main thread is waiting on the child to do the countdown
    }


}
