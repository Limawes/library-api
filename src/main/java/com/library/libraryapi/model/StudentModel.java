package com.library.libraryapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class StudentModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "Name")
  private String name;

  @Column(name = "Phone_number")
  private String phoneNumber;

  @Column(name = "Cpf")
  private String cpf;

  @Column(name = "Fine")
  private Long fine;//Multa

  @Column(name = "Checkbox")
  private Boolean checkbox;

  @OneToOne
  private AddressModel address;
}
