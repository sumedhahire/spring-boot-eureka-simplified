package com.example.order.order;


import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Builder
class OrderResponse{
    UUID id;
    String name;
    Float price;
    Integer quantity;
}


@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<OrderResponse> fetchAll(){
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public OrderResponse mapToResponse(Order order){
        return OrderResponse.builder().
                id(order.getId()).
                name(order.getName()).
                price(order.getPrice()).
                quantity(order.getQuantity()).
                build();

    }
}
