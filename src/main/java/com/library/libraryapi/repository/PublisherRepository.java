package com.library.libraryapi.repository;


import com.library.libraryapi.model.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherModel, Long> {

    Optional<PublisherModel> findById(Long id);
}
