package com.packt.modern.api.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cart")
@Data
@Builder
public class CartEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID", updatable = false, nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private UserEntity user;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "CART_ITEM",
            joinColumns = @JoinColumn(name = "CART_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    private List<ItemEntity> items;
}


