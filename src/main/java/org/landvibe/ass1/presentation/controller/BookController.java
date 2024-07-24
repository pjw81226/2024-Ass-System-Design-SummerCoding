package org.landvibe.ass1.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.landvibe.ass1.application.service.BookApplicationService;
import org.landvibe.ass1.domain.model.Book;
import org.landvibe.ass1.presentation.dto.BookSaveDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookApplicationService bookApplicationService;

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody BookSaveDto bookSaveDto) {
        int result = bookApplicationService.saveBook(bookSaveDto);
        if (result == 1) {
            return ResponseEntity.ok("Book Saved SuccessFully");
        }
        return ResponseEntity.status(500).body("Failed to save the book.");
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody BookSaveDto bookSaveDto) {
        int result = bookApplicationService.updateBook( id, bookSaveDto);
        if (result == 1) {
            return ResponseEntity.ok("Book Updated SuccessFully");
        }
        return ResponseEntity.status(500).body("Failed to update the book.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookApplicationService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookApplicationService.getAllBooks();
        return ResponseEntity.ok(books);
    }

}
