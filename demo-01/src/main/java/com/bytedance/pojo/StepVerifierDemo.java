package com.bytedance.pojo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 *@description:使用StepVerifier验证Flux响应流
 */
public class StepVerifierDemo {
    public static void main(String[] args) {

        Flux flux = Flux.just(1,2,3,4,5,6);

        StepVerifier.create(flux)
                .expectNext(1,2,3,4,5,6)
                .expectComplete()
                .verify();

        Mono mono = Mono.error(new Exception("some error"));
        StepVerifier.create(mono)
                .expectComplete()
                .verify();
    }
}
