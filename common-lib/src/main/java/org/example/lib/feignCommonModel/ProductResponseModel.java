package org.example.lib.feignCommonModel;

import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductResponseModel {
    private UUID id;
    private String name;
    private Float price;
    private Integer stock;
}
