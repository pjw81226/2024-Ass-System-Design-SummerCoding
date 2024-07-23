package org.landvibe.ass1.application.service;

import lombok.RequiredArgsConstructor;
import org.landvibe.ass1.application.mapper.BookDtoMapper;
import org.landvibe.ass1.domain.model.Book;
import org.landvibe.ass1.domain.repository.BookRepository;
import org.landvibe.ass1.domain.service.BookDomainService;
import org.landvibe.ass1.presentation.dto.BookSaveDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookApplicationService {
    private final BookDomainService bookDomainService;

    public int saveBook(BookSaveDto bookSaveDto) {
        Book book = BookDtoMapper.toDomain(bookSaveDto);
        return bookDomainService.saveBook(book);
    }

    public int updateBook(BookSaveDto bookSaveDto, Long id) {
        return bookDomainService.updateBook(bookSaveDto.getTitle(), id);
    }

    public Book getBookById(Long id) {
        return bookDomainService.getBookById(id);
    }

    public List<Book> getAllBooks() {
        return bookDomainService.getAllBooks();
    }

}
