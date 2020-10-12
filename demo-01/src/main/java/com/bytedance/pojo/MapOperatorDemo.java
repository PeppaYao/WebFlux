package com.bytedance.pojo;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class MapOperatorDemo {
    public static void main(String[] args) {
        StepVerifier.create(Flux.range(1, 6).
                map(i->i*i*i))
                //正常期望结果
                .expectNext(1,8,27,64,125,216)
                //异常期望结果
//                .expectNext(10,8,27,64,125,216)
                .expectComplete()
                .verify();

    }
}
