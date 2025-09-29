package com.example.order.order;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_uuid", columnDefinition = "VARCHAR(40)")
    private UUID id;

    @Column(name="product_uuid")
    private UUID productUUID;

    private String name;

    private float price;

    //technically this should be unsigned will look for libraries
    private int quantity;

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
