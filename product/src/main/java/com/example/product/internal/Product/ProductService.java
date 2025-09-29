package com.example.product.internal.Product;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/*
    this was rushed so please forgive me
    :(
 */


@NoArgsConstructor
@Getter
@Setter
class ProductResponse {
    private UUID id;
    private String name;
    private Float price;
    private Integer stock;

}

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductResponse> fetchAll(){
        return productRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public ProductResponse fetchById(UUID id){
        return productRepository.findById(id.toString())
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Not found"));

    }

    public ProductResponse mapToResponse(Product product){
        ProductResponse response=new ProductResponse();
        response.setId(UUID.fromString( product.getId()));
        response.setPrice(product.getPrice());
        response.setName(product.getName());
        response.setStock(product.getStock());
        return response;
    }
}


