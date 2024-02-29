package com.library.libraryapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class BookModel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private UUID id;

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

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_publisher", referencedColumnName = "id")
  private PublisherModel idPublisher;

}
