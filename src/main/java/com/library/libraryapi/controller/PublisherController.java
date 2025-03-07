package com.library.libraryapi.controller;

import com.library.libraryapi.dto.PublisherFillDTO;
import com.library.libraryapi.model.PublisherModel;
import com.library.libraryapi.service.PublisherService;
import com.library.libraryapi.service.exception.LibraryException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping("/api/library/publisher")
@RequiredArgsConstructor
public class PublisherController {

    @Autowired
    private final PublisherService publisherService;

    @PostMapping("/v1.0")
    @ResponseStatus
    public PublisherModel create(@RequestBody PublisherFillDTO publisher) {
        PublisherModel publisherModel = new PublisherModel();
        try {
            if (!Objects.isNull(publisher)) {
                publisherModel = publisherService.savePublisher(publisher);
            }
            return publisherModel;
        } catch (Exception e){
            throw new LibraryException(e.getMessage());
        }
    }
}
