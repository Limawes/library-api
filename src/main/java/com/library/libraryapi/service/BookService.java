package com.library.libraryapi.service;

import com.library.libraryapi.dto.BookDTO;
import com.library.libraryapi.dto.BookFillDto;
import com.library.libraryapi.model.BookModel;
import org.springframework.stereotype.Service;

@Service
public class BookService {


    private final PublisherService publisherService;

    public BookService(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    public BookModel saveBook(BookFillDto fillData) {
        BookModel book = new BookModel();

        book.setName(fillData.getName());
        book.setTopic(fillData.getTopic());
        book.setStatus(fillData.getStatus());
        book.setAuthor(fillData.getAuthorName());
        book.setTipping(fillData.getTipping());
        book.setPublisher(publisherService.findPublisherById(fillData.getPublisherId()));

        return book;
    }
}
