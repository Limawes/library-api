package com.library.libraryapi.service;

import com.library.libraryapi.dto.PublisherDTO;
import com.library.libraryapi.model.PublisherModel;
import com.library.libraryapi.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class PublisherService {

    private PublisherRepository repository;

    public PublisherService(PublisherRepository repository) {
        this.repository = repository;
    }

    public PublisherModel findPublisherById(Long publisherId) {
        try {

            PublisherDTO publisherDto = new PublisherDTO();

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

    private PublisherModel convertToPublisher(PublisherDTO dto) {
        PublisherModel publisher = new PublisherModel();
        publisher.setName(dto.getName());
        publisher.setAddress(dto.getAddress());
        publisher.setCnpj(dto.getCnpj());
        return publisher;
    }
}
