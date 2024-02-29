package com.library.libraryapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class EmployeeModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "Cpf")
  private String cpf;

  @Column(name = "Login", unique = true)
  private String login;

  @Column(name = "password")
  private String password;

  @Column(name = "Address")
  private String address;
}
