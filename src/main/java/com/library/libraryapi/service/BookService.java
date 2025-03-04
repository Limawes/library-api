package com.library.libraryapi.service;

import com.library.libraryapi.dto.BookDTO;
import com.library.libraryapi.model.BookModel;
import org.springframework.stereotype.Service;

@Service
public class BookService {


    private final PublisherService publisherService;

    public BookService(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    public BookModel saveBook(BookDTO bookdto) {
        BookModel book = new BookModel();

        //criar método para buscar o author a partir do authorId;

        book.setName(bookdto.getName());
        book.setTopic(bookdto.getTopic());
        book.setStatus(bookdto.getStatus());
//        book.setAuthor(authorService.findAuthorById(bookdto.getAuthorById));
        book.setTipping(bookdto.getTipping());
        book.setPublisher(publisherService.findPublisherById(bookdto.getPublisherId()));

        return book;
    }
}
