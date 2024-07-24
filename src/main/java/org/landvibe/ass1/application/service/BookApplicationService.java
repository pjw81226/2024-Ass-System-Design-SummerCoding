package org.landvibe.ass1.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.landvibe.ass1.application.mapper.BookDtoMapper;
import org.landvibe.ass1.common.annotation.CacheoutLandvibe;
import org.landvibe.ass1.common.annotation.CachingLandvibe;
import org.landvibe.ass1.domain.model.Book;
import org.landvibe.ass1.domain.service.BookDomainService;
import org.landvibe.ass1.presentation.dto.BookSaveDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookApplicationService {
    private final BookDomainService bookDomainService;

    public int saveBook(BookSaveDto bookSaveDto) {
        Book book = BookDtoMapper.toDomain(bookSaveDto);
        return bookDomainService.saveBook(book);
    }

    @CacheoutLandvibe(key = "book:<arg0>:data", cacheManager = "books")
    public int updateBook(Long id, BookSaveDto bookSaveDto) {
        log.info("updateBook");
        return bookDomainService.updateBook(bookSaveDto.getTitle(), id);
    }

    @CachingLandvibe(key = "book:<arg0>:data", cacheManager = "books")
    public Book getBookById(Long id) {
        log.info("getBookById");
        return bookDomainService.getBookById(id);
    }

    @CachingLandvibe(key = "books:all", cacheManager = "books")
    public List<Book> getAllBooks() {
        log.info("getAllBooks");
        return bookDomainService.getAllBooks();
    }

}
