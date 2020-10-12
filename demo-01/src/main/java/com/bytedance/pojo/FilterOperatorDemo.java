package com.bytedance.pojo;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FilterOperatorDemo {
    public static void main(String[] args) {
        //filter过滤出满足条件的元素
        StepVerifier.create(Flux.range(1,6)
                .filter(i->i%2==1)  //这里表示所有的奇数留下
                .map(i->i*i*i))
                .expectNext(1,27,125)
                .verifyComplete();

    }
}
