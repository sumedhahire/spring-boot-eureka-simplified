package com.example.product.internal.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class Controller {

    @Autowired
    private ProductService service;


    @GetMapping
    public List<ProductResponse> fetchAll(){
        return service.fetchAll();
    }

    @GetMapping("{id}")
    public ProductResponse fetchById(@PathVariable("id") UUID string){
        System.out.println("=slayyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
        return service.fetchById(string);
    }

}
