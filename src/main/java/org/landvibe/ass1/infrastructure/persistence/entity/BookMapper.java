package org.landvibe.ass1.infrastructure.persistence.entity;

import org.landvibe.ass1.domain.model.Book;

public class BookMapper {
    public static Book toDomain(BookEntity bookEntity) {
        return Book.builder()
                .id(bookEntity.getId())
                .title(bookEntity.getTitle())
                .build();
    }

    public static BookEntity toEntity(Book book) {
        return BookEntity.builder()
                .id(book.getId())
                .title(book.getTitle())
                .build();
    }
}
