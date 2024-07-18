package org.landvibe.ass1.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.landvibe.ass1.application.service.BookApplicationService;
import org.landvibe.ass1.application.service.RateLimiterService;
import org.landvibe.ass1.domain.model.Book;
import org.landvibe.ass1.presentation.dto.BookSaveDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookApplicationService bookApplicationService;
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody BookSaveDto bookSaveDto) {
        logger.debug("Received POST request to create a book");
        int result = bookApplicationService.saveBook(bookSaveDto);
        if (result == 1) {
            return ResponseEntity.ok("Book Saved Successfully");
        }
        return ResponseEntity.status(500).body("Failed to save the book.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        logger.debug("Received GET request to get a book by id: " + id);
        Book book = bookApplicationService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        logger.debug("Received GET request to get all books");
        List<Book> books = bookApplicationService.getAllBooks();
        return ResponseEntity.ok(books);
    }
}