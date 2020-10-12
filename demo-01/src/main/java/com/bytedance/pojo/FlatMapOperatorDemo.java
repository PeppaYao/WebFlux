package com.bytedance.pojo;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class FlatMapOperatorDemo {
    public static void main(String[] args) {
        //flatMap是异步的
        //流的合并是异步的，先来先到，并非是严格按照原始序列的顺序
        StepVerifier.create(
                Flux.just("flux", "mono")
                        .flatMap(s->Flux.fromArray(s.split("\\s*"))
                                //对每个元素延迟100ms
                                .delayElements(Duration.ofMillis(100)))
                        //对每个元素进行打印，.doOnNext不会消费数据流
                        .doOnNext(System.out::print))
                .expectNextCount(8)
                .verifyComplete();


    }
}
