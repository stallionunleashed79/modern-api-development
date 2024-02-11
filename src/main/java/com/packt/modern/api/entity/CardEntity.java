package com.packt.modern.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
@Entity
@Table(name = "card")
@Getter
@Setter
@Builder
public class CardEntity {
  @Id
  @GeneratedValue
  @Column(name = "ID", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "NUMBER")
  private String number;

  @Column(name = "EXPIRES")
  private String expires;

  @Column(name = "CVV")
  private String cvv;

  @OneToOne
  @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
  private UserEntity user;

  @OneToMany(mappedBy = "cardEntity", fetch = FetchType.LAZY, orphanRemoval = true)
  private List<OrderEntity> orders;
}
