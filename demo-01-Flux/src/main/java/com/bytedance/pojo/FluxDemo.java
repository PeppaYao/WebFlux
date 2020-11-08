package com.bytedance.pojo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public class FluxDemo {
    public static void main(String[] args) {
        //测试Flux
        Flux.just(1,2,3,4,5,6).subscribe(System.out::println);
        System.out.println("\n-----------------------");

        //测试Mono
        Mono.just(1).subscribe(System.out::println);
        System.out.println("\n-----------------------");

        //测试两个参数的subscribe方法
        Flux.just(1,2,3,4,5,6).subscribe(System.out::print, System.err::print);
        System.out.println("\n-----------------------");

        //测试三个参数的subscribe方法
        Flux.just(1,2,3,4,5,6).subscribe(System.out::print,
                System.err::print,
                ()->System.out.println("\ncomplete"));
        System.out.println("\n-----------------------");
    }
}
