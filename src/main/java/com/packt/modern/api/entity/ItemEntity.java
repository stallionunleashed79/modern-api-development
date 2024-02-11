package com.packt.modern.api.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
@Entity
@Table(name = "item")
@Getter
@Setter
@Builder
public class ItemEntity {

  @Id
  @GeneratedValue
  @Column(name = "ID", updatable = false, nullable = false)
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
  private ProductEntity product;

  @Column(name = "UNIT_PRICE")
  private BigDecimal price;

  @Column(name = "QUANTITY")
  private int quantity;

  @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
  private List<CartEntity> cart;

  @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
  private List<OrderEntity> orders;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemEntity that = (ItemEntity) o;
    return quantity == that.quantity && product.equals(that.product) && Objects
        .equals(price, that.price);// && Objects.equals(cart, that.cart);
  }

  @Override
  public int hashCode() {
    return Objects.hash(product, price, quantity);//, cart);
  }
}
