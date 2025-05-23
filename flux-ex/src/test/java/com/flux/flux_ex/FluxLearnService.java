// package com.flux.flux_ex;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;

// import reactor.core.publisher.Flux;
// import reactor.test.StepVerifier;

// @SpringBootTest
// public class FluxLearnService {

//     @Autowired
//     private FluxService fluxService;

//     // @Test
//     // void run(){
//     //     System.out.println("Hello Start : \n" +
//     //     "this is ");
//     // }

//     // @BeforeEach
//     // @Test
//     // void second(){
//     //     System.out.println("Hello Start : \n" +
//     //     "this is ");
//     //     Flux<String>result=fluxService.getString().log();
//     //     result.subscribe(System.out::println);
//     // }

//     // @Test
//     // void capString(){
//     //    Flux<String>fluxEx=fluxService.capString();
//     //    StepVerifier.create(fluxEx)
//     //    .expectNext("SHUBHAM","SONI","SALEHA","DISTT","PANNA","MP").verifyComplete();
//     // }

//     // @Test
//     // void filterExample(){
//     //    Flux<String>fluxEx=fluxService.filerExampleWith();
//     //    StepVerifier.create(fluxEx)
//     //    .expectNextCount(2).verifyComplete();
//     // }

//     // @Test
//     // void flatMapExample(){
//     //     StepVerifier.create(fluxService.flatMapExample()
//     //     ).expectNextCount(2).verifyComplete();
//     // }

//     // @Test
//     // void transformFunction(){
//     //    Flux<String> part= this.fluxService.transformFunction();
//     //    StepVerifier.create(part)
//     //    .expectNextCount(1).verifyComplete();
//     // }
//     // @Test
//     // void ifExampleFluxInRange(){
//     //     Flux<String> fe=this.fluxService.ifExampleFluxInRange(5);
//     //     StepVerifier.create(fe)
//     //     .expectNextCount(1).verifyComplete();
//     // }

//     // @Test
//     // void ifExampleFilter(){
//     //     Flux<String> fde=fluxService.ifExample(12);
//     //     StepVerifier.create(
//     //         fde
//     //     ).expectNextCount(4).verifyComplete();
//     // }

//     // @Test
//     // void concatEx(){
//     //     Flux<String> part=this.fluxService.methodConcat(5);
//     //     StepVerifier.create(part)
//     //     .expectNextCount(5).verifyComplete();
//     // }

//     @Test
//     void switchText(){
//         Flux<String>part=this.fluxService.switchEx(9);
//         StepVerifier.create(part)
//         .expectNextCount(3).verifyComplete();
//     }
// }

