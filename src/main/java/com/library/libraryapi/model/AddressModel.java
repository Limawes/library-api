package com.library.libraryapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AddressModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

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

  @OneToOne
  private EmployeeModel employee;

  @OneToOne
  private PublisherModel publisher;
}
