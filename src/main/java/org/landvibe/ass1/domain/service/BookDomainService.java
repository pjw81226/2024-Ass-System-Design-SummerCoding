package org.landvibe.ass1.domain.service;

import lombok.RequiredArgsConstructor;
import org.landvibe.ass1.common.error.ResourceNotFoundException;
import org.landvibe.ass1.domain.model.Book;
import org.landvibe.ass1.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookDomainService {
    private final BookRepository bookRepository;


    public int saveBook(Book book){
        return bookRepository.save(book);
    }


    public int updateBook(String title, Long id) {
        return bookRepository.update(title, id);
    }


    public Book getBookById(Long id) {
        return bookRepository.findBookById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book Not Found With Id: " + id));
    }

    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAllBooks();
        if (books.isEmpty()) {
            throw new ResourceNotFoundException("No Books");
        }
        return books;
    }
}
