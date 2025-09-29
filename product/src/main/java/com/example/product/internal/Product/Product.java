package com.example.product.internal.Product;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_uuid", length = 40)
    private String id;


    private String name;

    private float price;

    //technically this should be unsigned will look for libraries
    private int stock;

    @Column(name = "created_on", updatable = false, nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "updated_on", nullable = false)
    private LocalDateTime updatedOn;

    @Column(name = "deleted_on", nullable = true)
    private LocalDateTime deletedOn;

    //when it is created for the very first time
    @PrePersist
    public void onCreate(){
        createdOn=LocalDateTime.now();
        updatedOn=createdOn;
    }

    @PreUpdate
    public void onUpdate(){
        updatedOn= LocalDateTime.now();
    }

    //soft delete
    @PreRemove
    public void preRemove() {
        deletedOn = LocalDateTime.now();
    }
}
