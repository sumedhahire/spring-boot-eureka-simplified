package com.example.order.feign;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

//should be same name varibles
@Builder
public class ProductResponse {
    private UUID id;
    private String name;
    private Float price;
    private Integer stock;

}
