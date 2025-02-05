package com.rp.mono;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {

    public static void main(String[] args) {
        int userIdValid = 1;
        int userIdNull = 2; // not data for you
        int userIdError = 20;

        userRepository(userIdValid)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete()
                );

    }

    private static Mono<String> userRepository(int userId) {
        // 1
        if (userId == 1) {
            return Mono.just(Util.faker().name().firstName());
        } else if (userId == 2) {
            return Mono.empty(); // null
        } else
            return Mono.error(new RuntimeException("Not in the allowed range"));
    }

}
