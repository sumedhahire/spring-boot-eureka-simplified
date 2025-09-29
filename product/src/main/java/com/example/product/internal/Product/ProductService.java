package com.example.product.internal.Product;

import lombok.*;
import org.example.lib.feignCommonModel.ProductResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.product.internal.Product.Product; // correct
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/*
    this was rushed so please forgive me
    :(
 */




@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductResponseModel> fetchAll(){
        return productRepository.findAll()
                .stream()
                .map(this::mapToFeignResponse)
                .collect(Collectors.toList());
    }

    public ProductResponseModel fetchById(UUID id){
        return productRepository.findById(id.toString())
                .map(this::mapToFeignResponse)
                .orElseThrow(() -> new RuntimeException("Not found"));

    }

//    public ProductResponse mapToResponse(Product product){
//        ProductResponse response=new ProductResponse();
//        response.setId(UUID.fromString( product.getId()));
//        response.setPrice(product.getPrice());
//        response.setName(product.getName());
//        response.setStock(product.getStock());
//        return response;
//    }


    public ProductResponseModel mapToFeignResponse(Product product){
        ProductResponseModel response=new ProductResponseModel();
        response.setId(UUID.fromString( product.getId()));
        response.setPrice(product.getPrice());
        response.setName(product.getName());
        response.setStock(product.getStock());
        return response;
    }
}


