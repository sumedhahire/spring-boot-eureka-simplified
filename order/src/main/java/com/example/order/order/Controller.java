package com.example.order.order;


import com.example.order.feign.ProductClient;
import com.example.order.feign.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private OrderService service;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/order")
    public List<OrderResponse> fetchAll(){
        return service.fetchAll();
    }

    @GetMapping("/{id}")
    public ProductResponse fetchById(@PathVariable("id") UUID id){
        System.out.println("============================================================================hello");
        return productClient.fetchById(id);
    }
}
