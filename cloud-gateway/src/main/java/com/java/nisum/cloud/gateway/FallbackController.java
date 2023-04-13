package com.java.nisum.cloud.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/orderFallBack")
    public Mono<String> orderServiceFallBack() {
        return Mono.just("Order Service is taking too long to respond or is down. Please try again later");
    }
    @RequestMapping("/paymentFallback")
    public Mono<String> paymentServiceFallBack() {
        return Mono.just("Payment Service is taking too long to respond or is down. Please try again later");
    }

    @RequestMapping("/accountFallback")
    public Mono<String> accountServiceFallBack() {
        return Mono.just("Account Service is taking too long to respond or is down. Please try again later");
    }

    @RequestMapping("/fundTransferFallback")
    public Mono<String> fundTransferFallback() {
        return Mono.just("Posting the txn is taking too long to respond or is down. Please try again later");
    }


    @RequestMapping("/reportServiceFallback")
    public Mono<String> reportServiceFallback() {
        return Mono.just("Report service is taking too long to respond or is down. Please try again later");
    }

}
