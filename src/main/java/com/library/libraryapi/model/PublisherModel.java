package com.library.libraryapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class PublisherModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "Cnpj", unique = true)
  private String cnpj;

  @Column(name = "Name")
  private String name;
  
  @OneToOne
  private AddressModel address;
}
