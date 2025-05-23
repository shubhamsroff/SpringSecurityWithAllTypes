// package com.flux.flux_ex;

// import java.time.Duration;
// import java.util.function.Function;

// import org.springframework.stereotype.Service;

// import reactor.core.publisher.Flux;

// @Service
// public class FluxService {
    
//     // Simple Flux Example:-

//     public Flux<String> getString(){
//         return Flux.just("shubham");
//     }

//     // Map with their previous Flux:-
//     public Flux<String> capString(){
//         Flux<String>flux=Flux.just("shusonibham","srtgpdhoni","saldsfbeha","distsfvbdgt","panna","mp");
//         Flux<String>result=flux.map(map->map.toUpperCase()).log();
//         return result;
//     }

//     // Flux with Filter
//     public Flux<String> filerExampleWith(){
//         Flux<String> flux=Flux.just("this","is","our","thcountry","India");
//         Flux<String> filterFlux= flux.filter(data->
//         data.substring(0,2).equals("th"));
//         return filterFlux;
//     }


//     // Flux with FilterMap
//     public Flux<String> flatMapExample(){
//         return getString().flatMap(name->Flux.just(name.split(" "))).delayElements(Duration.ofSeconds(3)).log();
//     }

//     Function<Flux<String>,Flux<String>> transforms=(name)->name.map(nam->nam+"hi");
//     // Transform function with Flux
//     public Flux<String> transformFunction(){
//             return getString().transform(transforms).log();
//     }

//     public Flux<String> ifExampleFluxInRange(long length){
//         return getString().filter(name->name.length()>length).log();
//     }

//     public Flux<String> ifExample(int length){
//         return getString().filter(name->name.length()>5).defaultIfEmpty("we").log();
//     }

//     // Switch If Empty
//     public Flux<String>  switchEx(long length){
//         return getString().filter(name->name.length()>=length)
//         .switchIfEmpty(capString()).log();
//     }

//     // Concat Method as a Static
//     public Flux<String> methodConcat(long length){
//         return Flux.concat(getString(),capString()).filter(name->name.length()>=length);
//     }
// }
