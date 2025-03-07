package com.library.libraryapi.service;

import com.library.libraryapi.dto.BookFillDto;
import com.library.libraryapi.model.BookModel;
import com.library.libraryapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
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

        return book;
    }

    public List<BookModel> findBookByPublisherId(Long publisherId) {
        return  bookRepository.findByPublisherId(publisherId);
    }
}
