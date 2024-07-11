package org.landvibe.ass1.domain.repository;

import org.landvibe.ass1.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findBookById(Long id);

    List<Book> findAllBooks();

    int save(Book book);
}
