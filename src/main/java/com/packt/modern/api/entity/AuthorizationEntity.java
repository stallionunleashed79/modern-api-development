package com.packt.modern.api.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
@Entity
@Table(name = "authorization")
@Getter
@Setter
@Builder
public class AuthorizationEntity {

  @Id
  @GeneratedValue
  @Column(name = "ID", updatable = false, nullable = false)
  private UUID id;

  @Column(name="AUTHORIZED")
  private boolean authorized;

  @Column(name="TIME")
  private Timestamp time;

  @Column(name = "MESSAGE")
  private String message;

  @Column(name = "ERROR")
  private String error;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ORDER_ID", referencedColumnName = "id")
  private OrderEntity orderEntity;
}
