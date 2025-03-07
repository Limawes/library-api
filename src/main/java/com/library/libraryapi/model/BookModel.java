package com.library.libraryapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BookModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "Name")
  private String name;

  @Column(name = "Topic")//Tema/Assunto do livro
  private String topic;

  @Column(name = "Tipping")//Tombamento
  private Long tipping;

  @Column(name = "Status")
  private Boolean status;

  @Column(name = "Author")
  private String author;

  @Column(name = "active")
  private Boolean active;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_publisher", referencedColumnName = "id")
  private PublisherModel publisher;

}
