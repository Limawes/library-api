package com.library.libraryapi.controller;

import com.library.libraryapi.dto.BookFillDto;
import com.library.libraryapi.model.BookModel;
import com.library.libraryapi.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

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
           throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
       }
       return book;
    }
}
