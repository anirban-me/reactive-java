package com.rp.mono;

import com.rp.util.Util;
import com.rp.mono.assignment.FileService;

public class Lec09AssignmentDemo {

    public static void main(String[] args) {

        FileService.write("file03.txt", "This is file3")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.read("file03.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.delete("file03.txt")
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }

}
