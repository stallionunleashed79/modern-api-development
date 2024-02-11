package com.packt.modern.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
public class UserEntity {
  @Id
  @GeneratedValue
  @Column(name = "ID", updatable = false, nullable = false)
  private UUID id;

  @NotNull(message = "User name is required.")
  @Basic(optional = false)
  @Column(name = "USERNAME")
  private String username;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "FIRST_NAME")
  private String firstName;

  @Column(name = "LAST_NAME")
  private String lastName;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "PHONE")
  private String phone;

  @Column(name = "USER_STATUS")
  private String userStatus;

  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinTable(
      name = "USER_ADDRESS",
      joinColumns = @JoinColumn(name = "USER_ID"),
      inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID")
  )
  private List<AddressEntity> addresses = new ArrayList<>();

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
  private List<CardEntity> cards;

  @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = true)
  private CartEntity cart;

  @OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY, orphanRemoval = true)
  private List<OrderEntity> orders;
}
