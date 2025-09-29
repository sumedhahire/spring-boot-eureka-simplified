package com.example.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

//open connection and which service to connect to
@FeignClient(value = "PRODUCT-SERVICES")
public interface ProductClient {

    @GetMapping(value="/product/{id}")
    public ProductResponse fetchById(@PathVariable("id") UUID string);
}
