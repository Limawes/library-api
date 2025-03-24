package com.library.libraryapi.service;

import com.library.libraryapi.dto.PublisherDTO;
import com.library.libraryapi.dto.fill.PublisherFillDTO;
import com.library.libraryapi.model.AddressModel;
import com.library.libraryapi.model.PublisherModel;
import com.library.libraryapi.repository.PublisherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class PublisherService {

    private final PublisherRepository repository;
    private final AddressService addressService;

    public PublisherService(PublisherRepository repository, AddressService addressService) {
        this.repository = repository;
        this.addressService = addressService;
    }

    public PublisherModel findPublisherById(Long publisherId) {
        try {

            PublisherFillDTO publisherDto = new PublisherFillDTO();

            if (!Objects.isNull(publisherId)) {
                Optional<PublisherModel> publisherEncountered = repository.findById(publisherId);
                if (publisherEncountered.isPresent()) {
                    publisherDto.setName(publisherEncountered.get().getName());
                    publisherDto.setAddress(publisherEncountered.get().getAddress());
                    publisherDto.setCnpj(publisherEncountered.get().getCnpj());
                }
            }
            return convertToPublisher(publisherDto);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Transactional
    public PublisherModel savePublisher(PublisherFillDTO publisherDto) {
        PublisherModel publisher = new PublisherModel();
        if (!Objects.isNull(publisherDto)) {
            publisher.setName(publisher.getName());
            publisher.setAddress(publisherDto.getAddress());
            publisher.setCnpj(publisherDto.getCnpj());
        }
        return repository.save(publisher);
    }

    private PublisherModel convertToPublisher(PublisherFillDTO dto) {
        PublisherModel publisher = new PublisherModel();
        publisher.setName(dto.getName());
        publisher.setAddress(dto.getAddress());
        publisher.setCnpj(dto.getCnpj());
        return publisher;
    }

    public PublisherDTO converEntityToDTO(PublisherModel publisher) {
        PublisherDTO dto = new PublisherDTO();
        AddressModel address = addressService.getAddressById(publisher.getId());
        dto.setName(publisher.getName());
        dto.setCnpj(publisher.getCnpj());
        dto.setAddress(addressService.convertToDTO(address));

        return dto;
    }
}
