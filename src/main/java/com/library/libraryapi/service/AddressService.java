package com.library.libraryapi.service;

import com.library.libraryapi.dto.AddressDTO;
import com.library.libraryapi.model.AddressModel;
import com.library.libraryapi.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository repository;

    public AddressService(AddressRepository repository) { this.repository = repository; }

    public AddressModel getAddressById(long id) {
        return repository.findById(id);
    }

    public AddressDTO convertToDTO(AddressModel address) {
        AddressDTO dto = new AddressDTO();
        dto.setAddress(address.getAddress());
        dto.setCity(address.getCity());
        dto.setCountry(address.getCountry());
        dto.setPostCode(address.getPostCode());
        dto.setRegion(address.getRegion());
        dto.setNumber(address.getNumber());

        return dto;
    }
}
