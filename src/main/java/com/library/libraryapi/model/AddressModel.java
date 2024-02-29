package com.library.libraryapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class AddressModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "Address")
  private String address;

  @Column(name = "Number")
  private String number;

  @Column(name = "City")
  private String city;

  @Column(name = "Region")
  private String region;

  @Column(name = "Post_code")
  private String postCode;

  @Column(name = "Country")
  private String country;
}
