package com.library.libraryapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class PublisherModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "Cnpj", unique = true)
  private String cnpj;

  @Column(name = "Name")
  private String name;

  @Column(name = "Address")
  private String address;
}
