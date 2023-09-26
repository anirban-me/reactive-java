package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {

        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("process is done. Sending emails...");
                        }
                );
    }

    private static Runnable timeConsumingProcess() {
        // Runnable : doesn't accept values, doesn't return values
        // Use case : want to be notified for a time-consuming operation
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }

}
