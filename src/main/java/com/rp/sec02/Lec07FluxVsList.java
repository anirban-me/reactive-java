package com.rp.sec02;

import com.rp.courseutil.Util;
import com.rp.sec02.helper.NameGenerator;

import java.util.List;

public class Lec07FluxVsList {

    public static void main(String[] args) {

        List<String> names = NameGenerator.getNamesAsList(5);
        System.out.println(names); // prints only after 5 seconds

        // gives you as available as subscription object is continuously asking for data
        NameGenerator.getNamesAsFlux(5) // publisher
                .subscribe(Util.onNext());


    }

}
