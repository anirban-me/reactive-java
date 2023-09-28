package com.rp.sec02.helper;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    public static List<String> getNamesAsList(int count) {
        List<String> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(getName());
        }
        return list;
    }

    public static Flux<String> getNamesAsFlux(int count) {
        return Flux.range(0, count).map(i -> getName());
    }

    private static String getName() {
        Util.sleepSeconds(1); // Assuming that it is a time taking process
        return Util.faker().name().fullName();
    }

}
