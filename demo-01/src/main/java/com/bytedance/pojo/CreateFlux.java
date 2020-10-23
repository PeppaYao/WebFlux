package com.bytedance.pojo;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateFlux {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6);
        Mono<Integer> mono = Mono.just(1);
        //通过数组创建
        Integer[] integers = {1,2,3,4,5,6};
        Flux<Integer> arrayFlux = Flux.fromArray(integers);
        //通过集合创建
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Flux<Integer> listFlux = Flux.fromIterable(list);
        //通过Flux创建
        Flux<Integer> fluxFlux = Flux.from(flux);
        //通过流创建
        Flux<Integer> streamFlux = Flux.fromStream(Stream.of(1, 2, 3, 4, 5, 6));

        //订阅: 5个重载的构造函数
        //1. 订阅并触发数据流 subscribe()
        //2. 订阅并对正常数据元素进行处理subscribe(A)
        //3. 订阅并对正常数元素进行处理和异常信号进行处理subscribe(A,B)
        //4. 订阅并对正常数元素,异常信号,完成信号进行处理subscribe(A,B,C)
        //5. 订阅并对正常数元素,异常信号,完成信号和订阅发生时进行处理subscribe(A,B,C)

        flux.subscribe(System.out::println,
                System.err::print,
                ()->System.out.println("\ncomplete"),
                subscription -> {
                    System.out.println("订阅发生了");
                    subscription.request(3); //表示只需要3个元素
                });
        //使用自定义的订阅
        streamFlux.subscribe(new DemoSubscriber());

        //操作运算符的使用
        System.out.println("1.___________________________________________");
        listFlux.filter(i->i > 3).subscribe(System.out::println);  // 满足条件的保留
        System.out.println("2.___________________________________________");
        listFlux.flatMap(i->flux.just(i+100)).subscribe(System.out::println); //返回类型必须也为flux类型
        System.out.println("3.___________________________________________");
        Flux.zip(fluxFlux, arrayFlux).subscribe(zip-> System.out.println(zip.getT1()+zip.getT2())); //getT1()取第一个元素
        System.out.println("4.___________________________________________");

    }

    //自定义类
    static class DemoSubscriber extends BaseSubscriber<Integer> {
        @Override
        protected void hookOnSubscribe(Subscription subscription) {
            System.out.println("subscribe");
            subscription.request(1);
        }

        @Override
        protected void hookOnNext(Integer value) {
            if(value == 4){
                cancel(); //背压 当传到4时 就终止
            }
            System.out.println(value);
            request(1);
        }
    }
}
