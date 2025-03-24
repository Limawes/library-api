package com.library.libraryapi.controller;

import com.library.libraryapi.dto.fill.BookFillDto;
import com.library.libraryapi.model.BookModel;
import com.library.libraryapi.repository.BookRepository;
import com.library.libraryapi.service.BookService;
import com.library.libraryapi.service.exception.LibraryException;
import com.library.libraryapi.service.media.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/api/library/book")
public class BookController {


    private final BookRepository bookRepository;
    private final BookService bookService;


    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @PostMapping("/v1.0")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BookModel create(@RequestBody BookFillDto fillData) {
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

    @GetMapping("/v1.0/book/{bookId}")
    public BookModel getBookById(@PathVariable Long bookId) {
        BookModel book = bookRepository.findById(bookId).orElse(null);
        if(book == null) {
            log.info("No book found for id {}", bookId);
            throw new LibraryException("no book found for id: " + bookId);
        }
        return book;
    }

    @GetMapping("/v1.0/download-pdf")
    public ResponseEntity<byte[]> generatePDF() {
        byte[] retorno = ImageService.getImage();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "image.pdf");

        return new ResponseEntity<>(retorno, headers, HttpStatus.OK);
    }

}
