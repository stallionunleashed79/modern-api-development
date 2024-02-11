package com.packt.modern.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
@Entity
@Table(name = "payment")
@Getter
@Setter
@Builder
public class PaymentEntity {

  @Id
  @GeneratedValue
  @Column(name = "ID", updatable = false, nullable = false)
  private UUID id;

  @Column(name="AUTHORIZED")
  private boolean authorized;

  @Column(name = "MESSAGE")
  private String message;

  @OneToOne(mappedBy = "paymentEntity")
  private OrderEntity orderEntity;
}
