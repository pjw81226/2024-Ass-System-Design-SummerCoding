package org.landvibe.ass1.application.mapper;

import org.landvibe.ass1.domain.model.Book;
import org.landvibe.ass1.presentation.dto.BookSaveDto;

public class BookDtoMapper {
    public static Book toDomain(BookSaveDto bookSaveDto) {
        return Book.builder()
                .title(bookSaveDto.getTitle())
                .build();
    }

    public static BookSaveDto toDto(Book book) {
        return BookSaveDto.builder()
                .title(book.getTitle())
                .build();
    }
}
