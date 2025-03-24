package com.library.libraryapi.repository;

import com.library.libraryapi.model.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AddressRepository extends JpaRepository<AddressModel, Long> {

    AddressModel findById(long id);
}
