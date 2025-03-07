package com.library.libraryapi.repository;

import com.library.libraryapi.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {

    List<BookModel> findByPublisherId(Long publisherId);
}
