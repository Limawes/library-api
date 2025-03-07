package com.library.libraryapi.controller;

import com.library.libraryapi.dto.BookFillDto;
import com.library.libraryapi.model.BookModel;
import com.library.libraryapi.service.BookService;
import com.library.libraryapi.service.exception.LibraryException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/library/book")
public class BookController {


    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/v1.0")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookModel create(@RequestParam BookFillDto fillData) {
        BookModel book = new BookModel();
       try {
           if (!Objects.isNull(fillData)) {
              book =  bookService.saveBook(fillData);
           }
       } catch (Exception e) {
           log.error("Error while creating the book", e);
           throw new LibraryException(e.getMessage());
       }
       return book;
    }

    @GetMapping("/v1.0/publisher/{publisherId}")
    public List<BookModel> getAllBooksByPublisher(@PathVariable Long publisherId) {
        List<BookModel> bookList = bookService.findBookByPublisherId(publisherId);
        if(bookList.isEmpty()) {
            log.info("No books found for publisher id {}", publisherId);
            throw new LibraryException("no books found for publisherId: " + publisherId);
        }
        return bookList;
    }

}
